package com.example.pianostudio.ui2

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.pianostudio.page_navigation.PageNavigationRoot
import com.example.pianostudio.page_navigation.PageSwitcher
import com.example.pianostudio.page_navigation.rememberLocalPageNavigator


@Composable
fun Navigation(
    modifier: Modifier
) {
    PageNavigationRoot(
        startingRoute = "Tabs/Tab1",
        transitionSpec = fullScreenTransition
    ) {
        PageSwitcher(modifier = modifier) {
            page("Tabs") {
                Tabs(modifier = Modifier.fillMaxSize(),)
            }
            page("FullscreenPage1") {
                PlaceHolderFullScreen(
                    modifier = Modifier.fillMaxSize(),
                    name = "Fullscreen Page 1"
                )
            }
            page("FullscreenPage2") {
                PlaceHolderFullScreen(
                    modifier = Modifier.fillMaxSize(),
                    name = "Fullscreen Page 2"
                )
            }
        }
    }
}

@Composable
private fun Tabs(modifier: Modifier = Modifier) {
    val nav = rememberLocalPageNavigator()
    val selection = remember { mutableIntStateOf(0) }

    val lightBgColor = remember { mutableStateOf(Color.Black) }
    val darkBgColor = remember { mutableStateOf(Color.Black) }

    val animatedLightBg = animateColorAsState(targetValue = lightBgColor.value, label = "")
    val animatedDarkBg = animateColorAsState(targetValue = darkBgColor.value, label = "")

    LaunchedEffect(nav.nextPage) {
        when (nav.nextPage) {
            "Tab2" -> {
                selection.intValue = 1
                lightBgColor.value = Color(0xFF145250)
                darkBgColor.value = Color(0xFF0F3C37)
            }
            "Tab3" -> {
                selection.intValue = 2
                lightBgColor.value = Color(0xFF631841)
                darkBgColor.value = Color(0xFF491233)
            }
            "Tab4" -> {
                selection.intValue = 3
                lightBgColor.value = Color(0xFF351863)
                darkBgColor.value = Color(0xFF271249)
            }
            "Tab5" -> {
                selection.intValue = 4
                lightBgColor.value = Color(0xFF183263)
                darkBgColor.value = Color(0xFF122549)
            }
            else -> {
                selection.intValue = 0
                lightBgColor.value = Color(0xFF183263)
                darkBgColor.value = Color(0xFF122549)
            }
        }
    }

    Row(modifier = modifier.background(animatedDarkBg.value)) {
        MySideNavBar(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            selection = selection.intValue,
            color = animatedLightBg.value
        )

        PageSwitcher(
            modifier = Modifier
                .fillMaxSize()
                .weight(6f),
            transitionSpec = tabsTransition
        ) {
            page(name = "Tab1") {
                MainTabScreen(
                    modifier = Modifier.fillMaxSize(),
                )
            }
            page(name = "Tab2") {
                PlaceHolderScreen(
                    modifier = Modifier.fillMaxSize(),
                    name = "Tab2 Screen"
                )
            }
            page(name = "Tab3") {
                PlaceHolderScreen(
                    modifier = Modifier.fillMaxSize(),
                    name = "Tab3 Screen"
                )
            }
            page(name = "Tab4") {
                PlaceHolderScreen(
                    modifier = Modifier.fillMaxSize(),
                    name = "Tab4 Screen"
                )
            }
            page(name = "Tab5") {
                PlaceHolderScreen(
                    modifier = Modifier.fillMaxSize(),
                    name = "Tab5 Screen"
                )
            }
        }
    }
}