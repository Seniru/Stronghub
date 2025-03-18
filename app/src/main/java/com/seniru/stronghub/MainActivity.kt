package com.seniru.stronghub

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.signup)
        /*val intent = Intent(
            this@MainActivity,
            OnbordingActivity::class.java
        )
        startActivity(intent)*/
    }
}