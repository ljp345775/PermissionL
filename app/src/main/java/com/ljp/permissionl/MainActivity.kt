package com.ljp.permissionl

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ljp.library.L
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_request.setOnClickListener {
    L.request(this, android.Manifest.permission.CALL_PHONE) { b, list ->

        if (b) {
            Toast.makeText(this, "申请成功", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "list:${list[0]}", Toast.LENGTH_SHORT).show()
        }

    }
        }
    }
}
