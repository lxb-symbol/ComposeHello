package com.symbol.composehello.ui;

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyHorizontalScrollView() {

    var scrollState = rememberScrollState()
    val colors = remember {
        mutableStateListOf<Color>(
            Color.Red,
            Color.Green,
            Color.Gray,
            Color.Cyan,
            Color.Blue,
            Color.DarkGray,
            Color.Yellow
        )
    }
    Row(
        Modifier
            .horizontalScroll(state = scrollState)
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .padding(horizontal = 12.dp)
    ) {
        repeat(7) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
                    .background(color = colors[it]),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$it")
            }
        }
    }

}
