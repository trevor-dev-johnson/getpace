package xyz.getpace.pace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import xyz.getpace.pace.ui.navigation.PaceNavGraph
import xyz.getpace.pace.ui.theme.PaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaceTheme {
                PaceNavGraph()
            }
        }
    }
}
