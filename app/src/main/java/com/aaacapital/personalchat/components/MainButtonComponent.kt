package com.aaacapital.personalchat.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainButton(
    isLoading: Boolean,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(modifier = modifier.fillMaxWidth().height(60.dp), onClick = {
        onClick.invoke()
    }) {
        if(isLoading) DotsLoaderComponent() else Text(text = text)
    }
}

@Preview
@Composable
private fun PreviewBasedStateMainButton() {
    MainButton(isLoading = false, text = "Hello, world!", Modifier) { }
}

@Preview
@Composable
private fun PreviewLoadingStateMainButton() {
    MainButton(isLoading = true, text = "Hello, world!", Modifier) { }
}