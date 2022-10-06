package com.symbol.composehello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.symbol.composehello.ui.theme.ComposeHelloTheme
import com.symbol.widget.BottomNavType

/**
 * 主页
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainHomeScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainHomeScreen()
}

@Composable
fun MainHomeScreen() {
    val bottomSwitchState = remember { mutableStateOf(BottomNavType.TYPE_HOME) }
    ComposeHelloTheme {
        Column {
            ContentArea(
                bottomSwitchState.value,
                modifier = Modifier.weight(1f)
            )
            MainBottomNav(state = bottomSwitchState)
        }
    }
}


@Composable
fun ContentArea(type: BottomNavType, modifier: Modifier) {
    Column(modifier = modifier) {
        Crossfade(type) { content ->
            when (content) {
                BottomNavType.TYPE_HOME -> HomeScreen()
                BottomNavType.TYPE_MESSAGE_TYPE -> MessageScreen()
                BottomNavType.TYPE_NEWS -> NewsScreen()
                BottomNavType.TYPE_MINE -> MineScreen()
            }
        }
    }

}


/**
 * 主页
 */
@Composable
fun HomeScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "1. 文本组件",
            color = Color.Black,
            textAlign = TextAlign.Start,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Black,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Text(
            text = "FontWeight.Light",
            color = Color.LightGray,
            fontWeight = FontWeight.Light
        )

        Text(
            text = "FontWeight.Black",
            fontWeight = FontWeight.Black
        )
        Text(
            text = "FontWeight.ExtraBold",
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "FontWeight.SemiBold",
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "FontWeight.Medium",
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "FontWeight.Thin",
            fontWeight = FontWeight.Thin
        )
        Text(
            text = "FontWeight.w100",
            fontWeight = FontWeight.W100
        )
        Text(
            text = "FontWeight.w900",
            fontWeight = FontWeight.W900
        )

        Text(
            text = "FontFamily.Cursive",
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = "FontFamily.Monospace",
            fontFamily = FontFamily.Monospace
        )
        Text(
            text = stringResource(id = R.string.app_name),
            textDecoration = TextDecoration.LineThrough + TextDecoration.Underline
        )
        Text(
            text = """
            白日依山尽，
            黄河入海流。
            欲穷千里目，
            更上一层楼。
        """.trimMargin(),
            maxLines = 2
        )
        Text(
            text = "千山鸟飞绝，万里人踪灭".repeat(6),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        Text(
            text = "TextOverflow".repeat(6),
            overflow = TextOverflow.Clip,
            maxLines = 1
        )


    }

}


/**
 * 消息界面
 */
@Composable
fun MessageScreen() {

}

/**
 * 消息界面
 */
@Composable
fun NewsScreen() {

}

/**
 * 我的界面
 */
@Composable
fun MineScreen() {

}


@Composable
fun MainBottomNav(state: MutableState<BottomNavType>) {
    var animate by remember { mutableStateOf(false) }
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 4.dp,
    ) {
        BottomNavigationItem(
            selected = state.value == BottomNavType.TYPE_HOME,
            onClick = { state.value = BottomNavType.TYPE_HOME },
            icon = {

            },
            label = {
                Text(
                    text = "主页",
                    fontSize = 12.sp,
                    color = if (state.value == BottomNavType.TYPE_HOME) Color.Red else Color.Black
                )
            }
        )
        BottomNavigationItem(selected = state.value == BottomNavType.TYPE_MESSAGE_TYPE,
            onClick = { state.value = BottomNavType.TYPE_MESSAGE_TYPE },
            icon = {

            },
            label = {
                Text(
                    text = "消息",
                    fontSize = 12.sp,
                    color = if (state.value == BottomNavType.TYPE_MESSAGE_TYPE) Color.Red else Color.Black
                )
            }
        )
        BottomNavigationItem(selected = state.value == BottomNavType.TYPE_NEWS,
            onClick = { state.value = BottomNavType.TYPE_NEWS },
            icon = {},
            label = {
                Text(
                    text = "新闻",
                    fontSize = 12.sp,
                    color = if (state.value == BottomNavType.TYPE_NEWS) Color.Red else Color.Black
                )
            }
        )
        BottomNavigationItem(
            selected = state.value == BottomNavType.TYPE_MINE,
            onClick = { state.value = BottomNavType.TYPE_MINE },
            icon = {},
            label = {
                Text(
                    text = "我的",
                    fontSize = 12.sp,
                    color = if (state.value == BottomNavType.TYPE_MINE) Color.Red else Color.Black
                )
            }
        )


    }
}





