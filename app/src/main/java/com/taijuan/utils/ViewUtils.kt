package com.taijuan.utils

import android.view.View
import androidx.appcompat.widget.AppCompatImageView

/**
 * 防止抖动点击，多次访问问题
 */
fun View.onClick(body: () -> Unit, duration: Long = 500L) {
    var m = 0L
    this.setOnClickListener {
        val c = System.currentTimeMillis()
        if (c - m >= duration) {
            body()
            m = c
        }
    }
}