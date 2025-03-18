package com.seniru.stronghub

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnbordingActivity : AppCompatActivity() {

    var screen = 0
    val onboardingImages = arrayOf(
        R.drawable.eddie_hall_500kg,
        R.drawable.brian_shaw_bale_tote,
        R.drawable.big_z_austrian_oak
    )
    val onboardingScreenCircles = arrayOf(
        R.id.circleView,
        R.id.circleView2,
        R.id.circleView3
    )
    val onboardingTitles = arrayOf(
        "Welcome!",
        "Explore!",
        "Share!"
    )

    val onboardingDescriptions = arrayOf(
        "Get notified about upcoming competitions and latest results",
        "Find details about various competitions and athletes.\n" +
                "Compare athletes head-to-head",
        "Share your thoughts on hot strongman news.\n" +
                "Enjoy the vast collection of content uploaded by others"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        setContentView(R.layout.onboarding)

        val nextButton: Button = findViewById(R.id.next_button)
        val onboardingImage: ImageView = findViewById(R.id.onboarding_image)
        val onboardingTitle: TextView = findViewById(R.id.onboarding_title)
        val onboardingDescription: TextView = findViewById(R.id.onboarding_description)
        var currentCircle: View = findViewById(onboardingScreenCircles[0])
        nextButton.setOnClickListener {
            screen++;
            currentCircle.backgroundTintList = ContextCompat.getColorStateList(this, R.color.secondary)
            if (screen >= 3) {

            } else {
                currentCircle = findViewById(onboardingScreenCircles[screen])
                onboardingImage.setImageResource(onboardingImages[screen])
                onboardingTitle.setText(onboardingTitles[screen])
                onboardingDescription.setText(onboardingDescriptions[screen])
                var circle: View = findViewById(onboardingScreenCircles[screen])
                circle.backgroundTintList = ContextCompat.getColorStateList(this, R.color.black)
            }

        }

    }
}