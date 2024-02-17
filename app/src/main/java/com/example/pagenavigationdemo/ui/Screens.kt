package com.example.pianostudio.ui2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pianostudio.page_navigation.rememberLocalPageNavigator


@Composable
fun MainTabScreen(modifier: Modifier = Modifier) {
    val nav = rememberLocalPageNavigator()

    Column(
        modifier = modifier.padding(start = 40.dp, end = 40.dp, top = 10.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        Text(
            text = "Tab1 Screen",
            fontSize = 35.sp,
            color = Color.White,
            fontFamily = FontFamily.Default,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Button(
            onClick = { nav.navigateTo("FullscreenPage1") }
        ) {
            Text(
                text = "Fullscreen page 1",
                fontSize = 20.sp
            )
        }

        Button(
            onClick = { nav.navigateTo("FullscreenPage2") }
        ) {
            Text(
                text = "Fullscreen page 2",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun PlaceHolderScreen(
    modifier: Modifier = Modifier,
    name: String
) {
    Column(
        modifier = modifier.padding(start = 40.dp, end = 40.dp, top = 10.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = name,
            fontSize = 35.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = "Content",
            fontSize = 20.sp,
            color = Color.White,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun PlaceHolderFullScreen(
    modifier: Modifier = Modifier,
    name: String
) {
    val nav = rememberLocalPageNavigator()

    Column(
        modifier = modifier
            .clickable { nav.navigateTo("Tabs/Tab1") }
            .padding(start = 40.dp, end = 40.dp, top = 10.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = name,
            fontSize = 35.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = "Content",
            fontSize = 20.sp,
            color = Color.White,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
        )
    }
}