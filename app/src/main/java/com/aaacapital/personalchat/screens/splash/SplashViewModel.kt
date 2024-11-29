package com.aaacapital.personalchat.screens.splash

import com.aaacapital.personalchat.base.BaseViewModel

class SplashViewModel : BaseViewModel<SplashState, SplashEvent, SplashEffect>() {
    override fun setInitialState() = SplashState()

    override fun handleEvent(event: SplashEvent) {
        when(event) {
            else -> Unit
        }
    }
}