package com.symbol.composehello

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
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
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "1. 文本组件",
            color = Color.Black,
            fontSize = 18.sp,
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

        Text(
            text = "关于 shape",
            Modifier
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                )
                .padding(horizontal = 12.dp, vertical = 6.dp),
            color = Color.Cyan
        )

        Box(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
            Text(
                text = "待点击的 Text",
                Modifier
                    .clickable {
                        Log.e("Symbol", "click")
                        Toast
                            .makeText(context, "I'm a toast", Toast.LENGTH_LONG)
                            .show()
                    }
                    .background(
                        color = Color.LightGray, shape = RoundedCornerShape(
                            8
                        )
                    )
                    .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
            )
        }

        SelectionContainer(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .background(color = Color.LightGray)
        ) {
            Text(text = "可复制文字", modifier = Modifier.padding(12.dp))
        }

        val annotatedText = buildAnnotatedString {
            append("第一地段文字")
            append("第二段")
            pushStringAnnotation(tag = "tag", annotation = "第三段")
            withStyle(
                style = SpanStyle(
                    color = Color.Cyan,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("百度链接")
            }
            pop()
        }

        ClickableText(text = annotatedText,
            onClick = {
                annotatedText.getStringAnnotations(tag = "tag", start = it, end = it)
                    .firstOrNull()?.let { aString ->
                        Toast.makeText(context, aString.item, Toast.LENGTH_LONG).show()
                    }
            })

        val ss = buildAnnotatedString {
            append("白日依山尽")
            withStyle(SpanStyle(fontSize = 14.sp, color = Color.Cyan)) {
                append("黄河入海流")
            }
            withStyle(SpanStyle(fontSize = 12.sp, color = Color.Red)) {
                append("欲穷千里目")
            }
        }
        Text(text = ss)

        Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            Text(
                text = "2.TextFiled 组件",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        var inputText = remember {
            mutableStateOf("")
        }
        TextField(
            value = inputText.value,
            onValueChange = {
                inputText.value = it
            },
            placeholder = {
                Text(text = "请输入文字")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            OutlinedTextField(
                value = inputText.value,
                onValueChange = {
                    inputText.value = it
                },
                label = {
                    Text(text = "outlineTextField")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search, contentDescription = "图"
                    )
                },
                trailingIcon = {
                    Text(text = "@gmail.com")
                },


                )
        }

        Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            Text(
                text = "3.Icon 组件",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }


        Icon(
            bitmap = ImageBitmap.imageResource(id = R.mipmap.b1aa0c85f414485bc77a122592eea150),
            contentDescription = "bitmap"
        )

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "imageVector"
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "painter"
        )

        Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            Text(
                text = "4.Image组件",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Image(painter = painterResource(id = R.mipmap.a), contentDescription = "图片")

        Surface(
            shape = CircleShape,
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Image(painter = painterResource(id = R.mipmap.b), contentDescription = "circleImage")
        }
        Image(
            painter = painterResource(id = R.mipmap.b1aa0c85f414485bc77a122592eea150),
            contentDescription = "大小",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(120.dp)
        )


        Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            Text(
                text = "5. Card组件",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            border = BorderStroke(width = 2.dp, color = Color.Gray),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Text(
                text = "标题", fontSize = 16.sp, fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 12.dp, bottom = 12.dp, start = 12.dp, end = 12.dp)
            )
            Text(
                text = "内容什么内容呀？", fontSize = 14.sp, fontWeight = FontWeight.Light,
                modifier = Modifier.padding(bottom = 12.dp, start = 12.dp, end = 12.dp)
            )
        }

        Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            Text(
                text = "6. FloatingActionButton 和 Dialog组件",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        var showD = remember {
            mutableStateOf(false)
        }
        FloatingActionButton(
            onClick = {
                showD.value = !showD.value
            },
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 4.dp)
        ) {

        }


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





