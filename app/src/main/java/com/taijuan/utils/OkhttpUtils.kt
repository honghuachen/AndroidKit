package com.taijuan.utils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

val okHttpClient: OkHttpClient by lazy {
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()
    okHttpClient
}