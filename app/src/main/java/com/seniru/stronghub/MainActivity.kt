package com.seniru.stronghub

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.launchscreen)
        Handler().postDelayed({
            val onboardingIntent = Intent(
                this@MainActivity,
                OnboardingActivity::class.java
            )
            startActivity(onboardingIntent)
            finish()
        }, 1000)
    }
}