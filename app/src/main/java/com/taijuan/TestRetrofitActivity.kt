package com.taijuan

import android.os.Bundle
import androidx.lifecycle.Observer
import com.google.gson.JsonObject
import com.taijuan.api.testService
import com.taijuan.base.BaseActivity
import com.taijuan.base.model.BaseRes
import com.taijuan.retrofit.Error
import com.taijuan.retrofit.Success
import kotlinx.android.synthetic.main.activity_test_retrofit.*

class TestRetrofitActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_retrofit)
        testService.getUser("asia", 1, 1).observe(this, Observer {
            if (it is Success<BaseRes<JsonObject>>) {
                tv.text = "${it.body}"
            }
            if (it is Error) {
                tv.text = "${it.errorMsg}"
            }
        })
    }
}