package com.taijuan

import android.os.Bundle
import com.taijuan.base.BaseActivity
import com.taijuan.uuid.getUUID
import kotlinx.android.synthetic.main.activity_test_retrofit.*

class TestUUIDActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_retrofit)
        tv.text = this.application.getUUID()
    }
}