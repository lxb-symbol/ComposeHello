package com.symbol.composehello.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.symbol.composehello.R

/**
 * 消息界面
 */
@OptIn(ExperimentalAnimationApi::class, ExperimentalFoundationApi::class)
@Composable
fun MessageScreen() {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {

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

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Cyan, shape = RoundedCornerShape(4.dp))
                .combinedClickable(
                    onClick = {
                        Toast
                            .makeText(context, "onclick", Toast.LENGTH_LONG)
                            .show()
                    },
                    onLongClick = {
                        Toast
                            .makeText(context, "LongClick", Toast.LENGTH_LONG)
                            .show()
                    },
                    onDoubleClick = {
                        Toast
                            .makeText(context, "doubleClick", Toast.LENGTH_LONG)
                            .show()
                    }),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Box")
        }
//双击
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(color = Color.Green)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            Toast
                                .makeText(context, "DoubleTap", Toast.LENGTH_SHORT)
                                .show()
                        },
                        onLongPress = {
                            Toast
                                .makeText(context, "LongPress", Toast.LENGTH_SHORT)
                                .show()
                        },
                        onPress = {
                            Toast
                                .makeText(context, "press", Toast.LENGTH_SHORT)
                                .show()
                        },
                        onTap = {
                            Toast
                                .makeText(context, "onTap", Toast.LENGTH_SHORT)
                                .show()
                        })
                }
        )

        Spacer(modifier = Modifier.height(12.dp))

        var ofx by remember { mutableStateOf(0.dp) }
        var ofy by remember { mutableStateOf(0.dp) }


//    多点触控监听
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color = Color.Magenta)
        ) {
            Box(modifier = Modifier
                .size(40.dp)
                .offset {
                    IntOffset(ofx.roundToPx(), ofy.roundToPx())
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->

                        change.consume()
                        ofx += dragAmount.x.toDp()
                        ofy += dragAmount.y.toDp()
                    }
                }
                .background(color = Color.LightGray)
            )
        }

//        旋转，缩放，box
        Spacer(modifier = Modifier.height(12.dp))
        MyTouchBox()

//        滚动相关
        MyHorizontalScrollView()
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dp_4)))

//        LazyColumn
        MyLazyColumnView()


    }


}