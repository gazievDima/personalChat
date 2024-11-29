package com.aaacapital.personalchat

import android.app.Application
import com.aaacapital.personalchat.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PersonalChatApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PersonalChatApplication)
            modules(commonModule)
        }
    }
}