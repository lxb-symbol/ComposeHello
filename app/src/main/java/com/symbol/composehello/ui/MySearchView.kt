package com.symbol.composehello.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * 作为搜素的样式使用的是 Text 并不是 TextField
 */
@Composable
fun MySearchView(dpListener: (Float) -> Unit) {
    val textContentState = remember { mutableStateOf("") }
    val change = remember { mutableStateOf(false) }
    val sizeState = animateFloatAsState(
        targetValue = if (change.value) 1f else 0.5f,
        finishedListener = dpListener
    )

    Row(
        modifier = Modifier
            .fillMaxWidth(sizeState.value)
            .height(42.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(18.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Icon(imageVector = Icons.Filled.Search, contentDescription = "搜索")
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "文字域可边长",
            modifier = Modifier.clickable {
                change.value = !change.value
            }
        )
    }
}


