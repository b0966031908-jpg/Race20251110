import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import tw.edu.pu.csim.s1131235.race.GameViewModel

@Composable
fun GameScreen(message: String, gameViewModel: GameViewModel) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow)
    ){
        Text(text = message + gameViewModel.screenWidthPx.toString() + "*" + gameViewModel.screenHeightPx.toString())
    }
}