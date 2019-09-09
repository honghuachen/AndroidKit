package com.taijuan

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.taijuan.permission.request
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRequestPermission.setOnClickListener {
            request(
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_FINE_LOCATION,
                onGranted = {
                    tv.text = "onGranted\n"
                },
                onDenied = { a, b ->
                    tv.append("onDenied: ${a}\n")
                },
                onShowRationale = { a, b ->
                    tv.append("onShowRationale: ${a}\n")
                },
                onNeverAskAgain = { a, b ->
                    tv.append("onNeverAskAgain: ${a}\n")
                }
            )
        }
    }
}
