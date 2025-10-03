package com.example.lazyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lazyapp.ui.ChampionsScreen
import com.example.lazyapp.ui.theme.LazyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyAppTheme {
                ChampionsScreen()
            }
        }
    }
}
