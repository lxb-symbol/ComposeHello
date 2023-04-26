package com.symbol.composehello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.symbol.composehello.ui.HomeScreen
import com.symbol.composehello.ui.MainBottomNav
import com.symbol.composehello.ui.MessageScreen
import com.symbol.composehello.ui.MineScreen
import com.symbol.composehello.ui.NewsScreen
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














