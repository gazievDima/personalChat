package com.aaacapital.personalchat

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaacapital.personalchat.components.MainButton
import kotlinx.coroutines.launch

fun sendRequest(): Boolean = true

@Composable
fun TestScreen() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val coroutineScope = rememberCoroutineScope()
            var isSendRequest by remember { mutableStateOf(false) }
            val alphaAnimation = remember { Animatable(1f) }

            Column {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_mark_unread_chat_alt_24),
                        contentDescription = null,
                        modifier = Modifier.size(120.dp),
                        alpha = alphaAnimation.value
                    )
                }
                MainButton(isLoading = isSendRequest, text = "Example dots loader") {
                    isSendRequest = sendRequest()
                }
                Spacer(modifier = Modifier.size(16.dp))
                MainButton(isLoading = false, text = "Example circle loader") {
                    coroutineScope.launch {
                        alphaAnimation
                            .animateTo(0f, animationSpec = tween(durationMillis = 1000))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTestScreen() {
    TestScreen()
}