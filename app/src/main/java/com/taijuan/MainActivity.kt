package com.taijuan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.taijuan.utils.onClick
import com.taijuan.utils.push
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPermission.onClick({
            push(TestPermissionActivity::class.java)
        })
        btnUUID.onClick({
            push(TestUUIDActivity::class.java)
        })
        btnRetrofit.onClick({
            push(TestRetrofitActivity::class.java)
        })

    }
}
