package com.example.pagenavigationdemo.ui

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import com.example.pagenavigationdemo.page_navigation.myTransition

val fullScreenTransition: myTransition = {
    fadeIn(
        animationSpec = tween(400)
    ) + scaleIn(
        initialScale = 1.07f,
        animationSpec = tween(500)
    ) togetherWith
    fadeOut(
        animationSpec = tween(400)
    ) + scaleOut(
        targetScale = 0.93f,
        animationSpec = tween(500)
    )
}

val tabsTransition: myTransition = {
    fadeIn(
        animationSpec = tween(300, delayMillis = 0)
    ) togetherWith fadeOut(
        animationSpec = tween(300)
    )
}

//val mainPagesTransition: myTransition = {
//    fadeIn(
//        animationSpec = tween(200, delayMillis = 200)
//    ) + scaleIn(
//        initialScale = 1.04f,
//        animationSpec = tween(400)
//    ) togetherWith
//            fadeOut(
//                animationSpec = tween(200)
//            ) + scaleOut(
//        targetScale = 0.96f,
//        animationSpec = tween(400)
//    )
//}