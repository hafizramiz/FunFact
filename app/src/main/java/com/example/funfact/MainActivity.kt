package com.example.funfact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.funfact.ui.theme.FunFactTheme
import com.hafizramiz.funfacts.ui.screens.FunFactsNavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Splash Screen'i build gradle'a ekledim
        // simdi burda initialize etmem gerekiyor.
        installSplashScreen()
        setContent {
            FunFactTheme {
                FunFactApp()
            }
        }
    }
}


@Composable
fun FunFactApp() {
    FunFactsNavigationGraph()
}