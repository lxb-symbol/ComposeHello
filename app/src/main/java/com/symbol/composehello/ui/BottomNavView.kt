package com.symbol.composehello.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.symbol.widget.BottomNavType


@Composable
 fun MainBottomNav(state: MutableState<BottomNavType>) {
    var animate by remember { mutableStateOf(false) }
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 4.dp,
        modifier = Modifier.height(52.dp)
    ) {
        BottomNavigationItem(
            selected = state.value == BottomNavType.TYPE_HOME,
            onClick = { state.value = BottomNavType.TYPE_HOME },
            icon = {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "主页")
            },
            label = {
                Text(
                    modifier = Modifier.padding(top = 4.dp),

                    text = "主页",
                    fontSize = 12.sp,
                    color = if (state.value == BottomNavType.TYPE_HOME) Color.Red else Color.Black
                )
            }
        )
        BottomNavigationItem(selected = state.value == BottomNavType.TYPE_MESSAGE_TYPE,
            onClick = { state.value = BottomNavType.TYPE_MESSAGE_TYPE },
            icon = {
                Icon(imageVector = Icons.Filled.Message, contentDescription = "消息")

            },
            label = {
                Text(
                    modifier = Modifier.padding(top = 4.dp),

                    text = "消息",
                    fontSize = 12.sp,
                    color = if (state.value == BottomNavType.TYPE_MESSAGE_TYPE) Color.Red else Color.Black
                )
            }
        )
        BottomNavigationItem(selected = state.value == BottomNavType.TYPE_NEWS,
            onClick = { state.value = BottomNavType.TYPE_NEWS },
            icon = {
                Icon(imageVector = Icons.Filled.Newspaper, contentDescription = "新闻")
            },
            label = {
                Text(
                    modifier = Modifier.padding(top = 4.dp),

                    text = "新闻",
                    fontSize = 12.sp,
                    color = if (state.value == BottomNavType.TYPE_NEWS) Color.Red else Color.Black
                )
            }
        )
        BottomNavigationItem(
            selected = state.value == BottomNavType.TYPE_MINE,
            onClick = { state.value = BottomNavType.TYPE_MINE },
            icon = {
                Icon(imageVector = Icons.Filled.NearMe, contentDescription = "我的")
            },
            label = {
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "我的",
                    fontSize = 12.sp,
                    color = if (state.value == BottomNavType.TYPE_MINE) Color.Red else Color.Black
                )
            }
        )


    }
}
