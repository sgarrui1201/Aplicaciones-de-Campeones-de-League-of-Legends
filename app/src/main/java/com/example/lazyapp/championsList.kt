package com.example.lazyapp.ui

import coil.compose.AsyncImage
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.lazyapp.R

data class Champion(
    val name: String,
    val title: String,
    val lore: String,
    val imageResId: Int
)

val championsList = listOf(
    Champion(
        "Annie",
        "La niña oscura",
        "Annie es una joven maga con poderes pirotécnicos que puede invocar a su oso de peluche, Tibbers.",
        R.drawable.annie
    ),
    Champion(
        "Diana",
        "La despreciada de la luna",
        "Diana es una guerrera feroz que abraza el poder de la luna para combatir en la batalla.",
        R.drawable.diana
    ),
    Champion(
        "Fizz",
        "El bromista de las mareas",
        "Fizz es un tritón ágil y escurridizo que usa su tridente para burlar a sus enemigos.",
        R.drawable.fizz
    ),
    Champion(
        "Irelia",
        "La bailarina de las cuchillas",
        "Irelia controla cuchillas telequinéticas para dominar el campo de batalla con gracia y poder.",
        R.drawable.irelia
    ),
    Champion(
        "Leona",
        "El amanecer radiante",
        "Leona es una guerrera solar que usa el poder del sol para proteger y atacar con fuerza implacable.",
        R.drawable.leona
    ),
    Champion(
        "Mordekaiser",
        "El Señor de la muerte",
        "Mordekaiser es un poderoso guerrero no-muerto que domina el campo de batalla con fuerza brutal y magia oscura.",
        R.drawable.mordekaiser
    ),
    Champion(
        "Neeko",
        "La camaleona curiosa",
        "Neeko es una hechicera con habilidades para cambiar de forma y sorprender a sus enemigos.",
        R.drawable.neeko
    ),
    Champion(
        "Senna",
        "La redentora",
        "Senna es una guerrera que usa su cañón para eliminar las sombras y salvar almas perdidas.",
        R.drawable.senna
    ),
    Champion(
        "Taric",
        "El protector",
        "Taric es el guardián de la gema y usa su poder para proteger a sus aliados con luz y escudos mágicos.",
        R.drawable.taric
    ),
    Champion(
        "Teemo",
        "El explorador veloz",
        "Teemo es un explorador rápido y sigiloso que usa trampas y venenos para controlar el mapa.",
        R.drawable.teemo
    ),
    Champion(
        "Vi",
        "La ex-policía piltoveriana",
        "Vi es una luchadora con guanteletes mecánicos que da golpes demoledores y se enfrenta a sus enemigos con valentía.",
        R.drawable.vi
    ),
    Champion(
        "Ziggs",
        "El saboteador loco",
        "Ziggs es un yordle explosivo que adora hacer estallar todo a su paso con bombas y explosivos.",
        R.drawable.ziggs
    )
)

@Composable
fun ChampionItem(champion: Champion) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = champion.imageResId),
            contentDescription = champion.name,
            modifier = Modifier
                .size(100.dp)
                .border(BorderStroke(1.dp, Color.Gray))
                .padding(4.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = champion.name,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = champion.title,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = champion.lore,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun ChampionsList(champions: List<Champion>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(champions) { champion ->
            ChampionItem(champion = champion)
            Divider()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChampionsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LazyApp")
                }
            )
        }
    ) { innerPadding ->
        // Aplica padding para que el contenido no quede bajo el TopAppBar
        Box(modifier = Modifier.padding(innerPadding)) {
            ChampionsList(champions = championsList)
        }
    }
}
