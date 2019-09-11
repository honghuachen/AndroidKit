package com.taijuan.api

import androidx.lifecycle.LiveData
import com.google.gson.JsonObject
import com.taijuan.base.model.BaseRes
import com.taijuan.retrofit.GsonConverterFactory
import com.taijuan.retrofit.LiveDataCallAdapterFactory
import com.taijuan.retrofit.SuccessError
import com.taijuan.utils.okHttpClient
import retrofit2.Retrofit
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

val testService: SportService by lazy {
    Retrofit.Builder().baseUrl("https://api.cdeclips.com/hknews-api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
        .callFactory(
            okHttpClient
        )
        .build()
        .create(SportService::class.java)
}


interface SportService {
    /**
     * currentPage=$curPage&dataType=1
     */
    @FormUrlEncoded
    @POST("selectNewsList")
    fun getUser(
        @Field("subjectCode") code: String,
        @Field("currentPage") curPage: Int,
        @Field("dataType") type: Int
    ): LiveData<SuccessError<BaseRes<JsonObject>>>
}