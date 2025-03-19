package com.seniru.stronghub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.signup)

        val redirectLoginButton: TextView = findViewById(R.id.redirect_login_btn)
        redirectLoginButton.setOnClickListener {
            val signupIntent = Intent(
                this@SignupActivity,
                LoginActivity::class.java
            )
            startActivity(signupIntent)
        }

        val redirectMainButton: Button = findViewById(R.id.signup_button)
        redirectMainButton.setOnClickListener {
            val mainIntent = Intent(
                this@SignupActivity,
                MainScreenActivity::class.java
            )
            startActivity(mainIntent)
        }

    }
}