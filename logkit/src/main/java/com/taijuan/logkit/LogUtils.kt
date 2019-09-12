package com.taijuan.logkit

import android.util.Log
import androidx.annotation.Keep
import com.safframework.log.L
import com.safframework.log.json


private const val TAG = "LogUtils"
private var debug = BuildConfig.DEBUG
/**
 * 日志开关
 */
@Keep
fun setLogDebug() {
    debug = true
}

fun Any.logE(tag: Any = TAG, name: Any = "") {
    if (debug) {
        L.e("$tag", "$name${this}")
    }
}

fun Any.logI(tag: Any = TAG, name: Any = "") {
    if (debug) {
        L.i("$tag", "$name${this}")
    }
    L.json()
}

fun Any.json() {
    L.json(this)
}


fun Throwable.logT(tag: Any = TAG, name: Any = "") {
    if (debug) {
        Log.e(TAG, "$name", this)
    }
}