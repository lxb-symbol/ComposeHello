package com.symbol.composehello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
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
    val clickState = remember { mutableStateOf(BottomNavType.TYPE_HOME) }
    ComposeHelloTheme {
        MainBottomNav(state = clickState)
    }
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





