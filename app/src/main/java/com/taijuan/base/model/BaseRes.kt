package com.taijuan.base.model

import com.google.gson.annotations.SerializedName

/**
 * 直接解析data为非数组对象
 */
data class BaseRes<T>(
    @SerializedName("resCode") val code: Int,
    @SerializedName("resObject") val data: T,
    @SerializedName("resMsg") val msg: String
)