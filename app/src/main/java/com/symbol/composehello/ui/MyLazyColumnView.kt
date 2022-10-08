package com.symbol.composehello.ui;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyLazyColumnView() {

    LazyColumn(
        Modifier
            .background(color = Color.LightGray)
            .padding(top = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
            .height(200.dp)
    ) {
        item {
            Box(
                modifier = Modifier.background(color = Color.White).fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "第一条信息")
            }
        }
        items(10) {

            Box(
                modifier = Modifier.background(color = Color.White).fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "content")
            }
        }

        item {
            Box(
                modifier = Modifier.background(color = Color.White).fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "到底部了")
            }
        }
    }

}
