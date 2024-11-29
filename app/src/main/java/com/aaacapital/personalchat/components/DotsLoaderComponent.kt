package com.aaacapital.personalchat.components

import androidx.annotation.ColorRes
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.aaacapital.personalchat.R
import kotlinx.coroutines.delay

@Composable
fun DotsLoaderComponent(
    modifier: Modifier = Modifier,
    sizeBalls: Dp = 10.dp,
    sizeJump: Int = -35,
    @ColorRes colorBall1: Int = R.color.lightYellow,
    @ColorRes colorBall2: Int = R.color.lightGreen,
    @ColorRes colorBall3: Int = R.color.lightRed,
) {
    var isMoved1 by remember { mutableStateOf(false) }
    var isMoved2 by remember { mutableStateOf(false) }
    var isMoved3 by remember { mutableStateOf(false) }
    val move1 by ballAnimateIntAsState(isMoved = isMoved1, sizeJump)
    val move2 by ballAnimateIntAsState(isMoved = isMoved2, sizeJump)
    val move3 by ballAnimateIntAsState(isMoved = isMoved3, sizeJump)

    LaunchedEffect(Unit) {
        isMoved1 = !isMoved1
        delay(250)
        isMoved2 = !isMoved2
        delay(250)
        isMoved3 = !isMoved3
    }
    Column(modifier = modifier) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .offset { IntOffset(0, move1) }
                    .clip(CircleShape)
                    .background(colorResource(colorBall1))
                    .size(sizeBalls)
            ) {

            }
            Spacer(modifier = Modifier.size(14.dp))
            Box(
                modifier = Modifier
                    .offset { IntOffset(0, move2) }
                    .clip(CircleShape)
                    .background(colorResource(colorBall2))
                    .size(sizeBalls)
            ) {

            }
            Spacer(modifier = Modifier.size(14.dp))
            Box(
                modifier = Modifier
                    .offset { IntOffset(0, move3) }
                    .clip(CircleShape)
                    .background(colorResource(colorBall3))
                    .size(sizeBalls)
            ) {

            }
        }
    }
}

@Composable
fun ballAnimateIntAsState(isMoved: Boolean, sizeJump: Int) =
    animateIntAsState(
        targetValue = if (isMoved) sizeJump else 0,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 500),
            repeatMode = RepeatMode.Reverse
        ),
        label = "move",
    )

@Preview()
@Composable
private fun PreviewLoaderComponent() {
    DotsLoaderComponent()
}