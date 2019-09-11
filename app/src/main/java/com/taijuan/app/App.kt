package com.taijuan.app

import android.app.Application
import androidx.annotation.Keep

@Keep
lateinit var app: App

@Keep
class App : Application() {

    override fun onCreate() {
        app = this
        super.onCreate()
    }
}