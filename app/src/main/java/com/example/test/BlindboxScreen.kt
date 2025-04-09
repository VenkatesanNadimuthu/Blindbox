package com.example.test

import BoxItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
fun BlindboxScreen() {
    val context = LocalContext.current
    val rewards = listOf(
        "Ultra Rare Charizard 🔥",
        "Foil Pikachu ⚡",
        "Holographic Mewtwo 🧠",
        "Regular Pidgey 🐦",
        "Reverse Holo Eevee ✨",
        "Nothing 😢"
    )

    val showResult = remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Choose a Blinxbox", color = Color.White, fontSize = 24.sp)

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(3) { index ->
                BoxItem(
                    imageRes = when (index) {
                        0 -> R.drawable.red_pack
                        1 -> R.drawable.blue_pack
                        else -> R.drawable.green_pack
                    },
                    onClick = {
                        showResult.value = rewards.random()
                    }
                )
            }
        }

        // Result Dialog
        showResult.value?.let { result ->
            AlertDialog(
                onDismissRequest = { showResult.value = null },
                title = { Text("🎉 You got:") },
                text = { Text(result) },
                confirmButton = {
                    TextButton(onClick = { showResult.value = null }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}