package com.taijuan.permission

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment

class PermissionFragment : Fragment() {

    private var permissionsCallback: PermissionsCallback? = null

    fun setOnPermissionsCallback(permissionsCallback: PermissionsCallback) {
        this.permissionsCallback = permissionsCallback
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    fun requestPermissionsByFragment(permissions: Array<String>, requestCode: Int) {
        requestPermissions(permissions, requestCode)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val neverAskPermissions = mutableListOf<String>()
        val deniedPermissions = mutableListOf<String>()
        val grantedPermissions = mutableListOf<String>()
        permissions.forEachIndexed { index, permission ->
            if (grantResults[index] == PackageManager.PERMISSION_DENIED) {
                if (!shouldShowRequestPermissionRationale(permission)) {
                    neverAskPermissions.add(permission)
                }
                deniedPermissions.add(permission)
            } else {
                grantedPermissions.add(permission)
            }
        }
        if (neverAskPermissions.isNotEmpty()) {
            permissionsCallback?.onNeverAskAgain(neverAskPermissions)
        }
        if (deniedPermissions.isNotEmpty()) {
            permissionsCallback?.onDenied(deniedPermissions)
        }
        if (deniedPermissions.isEmpty() && neverAskPermissions.isEmpty()) {
            permissionsCallback?.onGranted()
        }
    }
}