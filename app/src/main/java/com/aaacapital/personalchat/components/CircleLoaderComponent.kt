package com.aaacapital.personalchat.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CircleLoaderComponent(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
//        AnimatedContent(targetState =) {
//        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCircleLoaderComponent() {
    CircleLoaderComponent()
}