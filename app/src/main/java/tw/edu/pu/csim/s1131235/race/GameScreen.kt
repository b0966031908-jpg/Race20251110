import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tw.edu.pu.csim.s1131235.race.GameViewModel
import tw.edu.pu.csim.s1131235.race.R


@Composable
fun GameScreen(message: String, gameViewModel: GameViewModel) {

    //val imageBitmap = ImageBitmap.imageResource(R.drawable.horse0)改成下面的陣列
    val imageBitmaps = listOf(
        ImageBitmap.imageResource(R.drawable.horse0),
        ImageBitmap.imageResource(R.drawable.horse1),
        ImageBitmap.imageResource(R.drawable.horse2),
        ImageBitmap.imageResource(R.drawable.horse3)
    )


    val currentScore = gameViewModel.score
    val circleX = gameViewModel.circleX

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow)
    ){


        Text(
            text = "作者: 楊承智 ",
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        )


        Text(
            text = "分數: $currentScore",
            fontSize = 24.sp,
            color = Color.Blue,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )


        Canvas (modifier = Modifier.fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume() // 告訴系統已經處理了這個事件
                    gameViewModel.MoveCircle( dragAmount.x, dragAmount.y)
                }
            }

        ) {
            // 繪製圓形
            drawCircle(
                color = Color.Red,
                radius = 100f,
                center = Offset(gameViewModel.circleX, gameViewModel.circleY)
            )

            drawImage(
                image = imageBitmaps[gameViewModel.horse.HorseNo],
                dstOffset = IntOffset(gameViewModel.horse.HorseX,gameViewModel.horse.HorseY),
                dstSize = IntSize(200, 200)
            )

        }

        Text(text = message + gameViewModel.screenWidthPx.toString() + "*" + gameViewModel.screenHeightPx.toString())

        Button(onClick = {gameViewModel.gameRunning = true
                            gameViewModel.StartGame()
        }
            ,modifier = Modifier.align(Alignment.BottomCenter).padding(top = 32.dp)
        ){
            Text("遊戲開始")
        }
    }

}