package com.symbol.composehello.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LikeHeart() {
    var change by remember { mutableStateOf(false) }
    var flag by remember { mutableStateOf(false) }

    var sizeVariable = remember { Animatable(24.dp, Dp.VectorConverter) }

    LaunchedEffect(change) {
        sizeVariable.animateTo(if (change) 36.dp else 24.dp)
    }
    if (sizeVariable.value == 36.dp) {
        change = false
    }

    IconButton(onClick = {
        change = true
        flag = !flag
    }) {
        Icon(
            imageVector = Icons.Rounded.Favorite,
            contentDescription = "最爱",
            modifier = Modifier.size(sizeVariable.value),
            tint = if (flag) Color.Red else Color.LightGray
        )
    }

}