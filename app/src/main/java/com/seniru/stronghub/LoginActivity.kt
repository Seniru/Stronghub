package com.seniru.stronghub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login)

        val redirectSignupButton: TextView = findViewById(R.id.redirect_signup_btn)
        redirectSignupButton.setOnClickListener {
            val signupIntent = Intent(
                this@LoginActivity,
                SignupActivity::class.java
            )
            startActivity(signupIntent)
        }

        val redirectMainButton: Button = findViewById(R.id.login_button)
        redirectMainButton.setOnClickListener {
            val mainIntent = Intent(
                this@LoginActivity,
                MainScreenActivity::class.java
            )
            startActivity(mainIntent)
        }

    }
}