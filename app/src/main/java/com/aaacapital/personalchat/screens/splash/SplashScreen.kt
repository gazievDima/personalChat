package com.aaacapital.personalchat.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaacapital.personalchat.BaseContent
import com.aaacapital.personalchat.R
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    viewModel: SplashViewModel = koinViewModel()
) {
    val state = viewModel.uiState.collectAsState()
    Content(state.value, viewModel::sendEvent, modifier)
}

@Composable
private fun Content(
    state: SplashState,
    sendEvent: (SplashEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseContent(isLoading = state.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_mark_unread_chat_alt_24),
                    contentDescription = null,
                    modifier = Modifier.size(128.dp)
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    modifier = Modifier.wrapContentSize(),
                    fontSize = 30.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewContent(modifier: Modifier = Modifier) {
    Content(SplashState(), {})
}
