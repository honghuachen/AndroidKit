package com.taijuan

import android.Manifest
import android.os.Bundle
import com.taijuan.base.BaseActivity
import com.taijuan.permission.request
import com.taijuan.utils.onClick
import kotlinx.android.synthetic.main.activity_test_permission.*

class TestPermissionActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_permission)
        btnPermission.onClick({
            request(
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_FINE_LOCATION,
                onGranted = {
                    tv.append("onGranted\n")
                },
                onDenied = { a, _ ->
                    tv.append("onDenied\n")
                    tv.append("$a\n")
                }, onShowRationale = { a, _ ->
                    tv.append("onShowRationale\n")
                    tv.append("$a\n")
                }, onNeverAskAgain = { a, _ ->
                    tv.append("onNeverAskAgain\n")
                    tv.append("$a\n")
                })
        })
    }
}