package com.taijuan.uuid

import android.app.Application
import com.ut.device.UTDevice

fun Application.getUUID(): String {
    return UTDevice.getUtdid(this)
}
