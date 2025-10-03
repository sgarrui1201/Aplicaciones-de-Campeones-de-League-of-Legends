package com.example.lazyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.lazyapp.ui.ChampionsList
import com.example.lazyapp.ui.championsList
import com.example.lazyapp.ui.theme.LazyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ChampionsList(championsList)
                }
            }
        }
    }
}
