package com.ljp.library

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

/**
 * @author iyx
 * @date 2020/11/23 21:48
 * @description
 */

typealias PermissionCallback = ((Boolean, List<String>) -> Unit)

class InvisibleFragment : Fragment() {

    private var callback: PermissionCallback? = null

    fun requestNow(cb: PermissionCallback, vararg permissions: String) {
        callback = cb

        requestPermissions(permissions, 1)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if (requestCode == 1) {
            val deniedList: MutableList<String> = mutableListOf()
            for ((index, result) in grantResults.withIndex()) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    deniedList.add(permissions[index])
                }
            }
            val allGranted = deniedList.isEmpty()
            callback?.let { it(allGranted, deniedList) }

        }

    }

}