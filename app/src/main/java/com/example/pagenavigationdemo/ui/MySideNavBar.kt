package com.example.pianostudio.ui2

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.pianostudio.page_navigation.rememberLocalPageNavigator


@Composable
fun MySideNavBar(
    modifier: Modifier = Modifier,
    selection: Int,
    color: Color
) {
    val nav = rememberLocalPageNavigator()

    SideNavBar(
        modifier = modifier,
        bgColor = color,
        lineColor = Color.White,
        selection = selection,
        buttons = listOf(
            SideNavBarButtonState("Tab1") { nav.navigateTo("Tabs/Tab1") },
            SideNavBarButtonState("Tab2") { nav.navigateTo("Tabs/Tab2") },
            SideNavBarButtonState("Tab3") { nav.navigateTo("Tabs/Tab3") },
            SideNavBarButtonState("Tab4") { nav.navigateTo("Tabs/Tab4") },
            SideNavBarButtonState("Tab5") { nav.navigateTo("Tabs/Tab5") },
        )
    )
}