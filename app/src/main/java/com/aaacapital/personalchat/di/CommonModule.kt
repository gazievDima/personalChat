package com.aaacapital.personalchat.di

import com.aaacapital.personalchat.screens.splash.SplashViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val commonModule = module {
    viewModelOf(::SplashViewModel)
}