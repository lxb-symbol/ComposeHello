package com.symbol.composehello.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt


@Composable
fun MyTouchBox() {
    var boxSize = 100.dp
    var offset by remember { mutableStateOf(Offset.Zero) }
    var scale by remember { mutableStateOf(1f) }
    var rotate by remember { mutableStateOf(1f) }

    var transformstate = rememberTransformableState { zoom, pan, rotation ->
        scale *= zoom
        offset += pan
        rotate += rotation
    }

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

        Box(modifier = Modifier
            .size(boxSize)
            .rotate(rotate)
            .scale(scale)
            .offset {
                IntOffset(offset.x.roundToInt(), offset.y.roundToInt())
            }
            .background(color = Color.Yellow)
            .transformable(
                state = transformstate,
                lockRotationOnZoomPan = false
            )
        )


    }
}
