package com.example.retrofit

import JsonExample.JsonActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_launch.*

class Launch : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        retrofit_btn.setOnClickListener {
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()

        }

        json_btn.setOnClickListener {
            val intent = Intent(this , JsonActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}