package com.gzone.luckyno7

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CardGameScreen(viewModel: GameViewModel = viewModel()) {
    val players = viewModel.players
    val context = LocalContext.current
    val maroon = Color(0xFF800000)

    Surface(
        color = maroon,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Lucky No 7 - Card Game",
                style = MaterialTheme.typography.headlineMedium.copy(color = Color.White),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .background(Color.White.copy(alpha = 0.2f))
                    .padding(8.dp)
            ) {
                if (players.isEmpty()) {
                    Text(
                        text = "No players found. Try restarting the game.",
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                } else {
                    players.forEach { player ->
                        Column(
                            modifier = Modifier.padding(bottom = 16.dp)
                        ) {
                            Text(
                                text = "${player.name}'s Hand:",
                                style = MaterialTheme.typography.titleMedium.copy(color = Color.White),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                player.hand.forEach { card ->
                                    val resId = remember(card) {
                                        context.getCardResId(card)
                                    }

                                    Image(
                                        painter = painterResource(id = resId),
                                        contentDescription = "${card.value.display} of ${card.suit.symbol}",
                                        modifier = Modifier.size(72.dp)
                                    )
                                }
                            }
                        }
                    }

                    Button(
                        onClick = { viewModel.resetGame() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = maroon
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    ) {
                        Text("Restart Game")
                    }
                }
            }
        }
    }
}

private fun Context.getCardResId(card: Card): Int {
    return resources.getIdentifier(
        card.imageName(),
        "drawable",
        packageName
    )
}
