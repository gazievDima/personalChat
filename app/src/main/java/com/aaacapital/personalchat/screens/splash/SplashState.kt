package com.aaacapital.personalchat.screens.splash

import com.aaacapital.personalchat.base.BaseEffect
import com.aaacapital.personalchat.base.BaseEvent
import com.aaacapital.personalchat.base.BaseState

data class SplashState(
    val isLoading: Boolean = false
) : BaseState

sealed interface SplashEvent : BaseEvent

sealed interface SplashEffect : BaseEffect