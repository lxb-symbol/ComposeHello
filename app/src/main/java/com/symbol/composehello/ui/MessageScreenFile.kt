package com.symbol.composehello.ui

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.symbol.composehello.R

/**
 * 消息界面
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MessageScreen() {

    Column(modifier = Modifier.padding(16.dp)) {

        Text(text = "动画", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        val showText = remember { mutableStateOf(false) }

        AnimatedVisibility(visible = showText.value) {
            Text(text = "Symbol or RanB 节奏蓝调", style = MaterialTheme.typography.labelMedium)
        }

        Button(onClick = { showText.value = !showText.value }) {
            Text(text = if (showText.value) "隐藏" else "显示")
        }

        val doAnim = remember { mutableStateOf(false) }
        Button(onClick = { doAnim.value = !doAnim.value }) {
            Text(text = "执行动画")
        }

        AnimatedVisibility(
            visible = doAnim.value,
            enter = slideInHorizontally(
                initialOffsetX = { -200 },
                animationSpec = tween(durationMillis = 1000)
            ) + fadeIn(initialAlpha = 0.3f),
            exit = slideOutHorizontally() + fadeOut()
        ) {
            Text(text = "slideIn 和 slideOut")
        }
        Spacer(modifier = Modifier.height(12.dp))
        AnimatedVisibility(
            visible = doAnim.value,
            enter = scaleIn(animationSpec = tween(durationMillis = 1000)),
            exit = scaleOut()
        ) {
            Image(painter = painterResource(id = R.mipmap.a), contentDescription = "图片 a")
        }

        MySearchView {
            Log.e("symbol ", "dp is $it")
        }

        LikeHeart()

        androidx.compose.material.MaterialTheme

    }


}