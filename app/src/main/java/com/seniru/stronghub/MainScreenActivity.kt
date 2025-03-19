package com.seniru.stronghub

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.util.TypedValueCompat.dpToPx
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setMargins

class MainScreenActivity : AppCompatActivity() {

    var selected = 0
    val iconButtons = arrayOf(
        arrayOf("Contests", R.drawable.trophy_default, R.drawable.trophy_selected, R.layout.onboarding),
        arrayOf("Athletes", R.drawable.hand_default, R.drawable.hand_selected, R.layout.launchscreen),
        arrayOf("Community", R.drawable.community_default, R.drawable.community_selected, R.layout.launchscreen),
        arrayOf("Media", R.drawable.media_default, R.drawable.media_selected, R.layout.login),
        arrayOf("Profile", R.drawable.profile_image, R.drawable.profile_image, R.layout.signup)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main)
        switchScreens(0)
    }

    private fun switchScreens(screen: Int) {
        selected = screen
        drawNavigationBar()

        val mainFrame: FrameLayout = findViewById(R.id.main_section_frame)
        mainFrame.removeAllViews()

        val layoutResId = when (screen) {
            0 -> R.layout.contests
            1 -> R.layout.athlethes_index
            2 -> R.layout.community
            3 -> R.layout.media
            4 -> R.layout.profile
            else -> null
        }

        layoutResId?.let {
            val newLayout = layoutInflater.inflate(it, mainFrame, false)
            mainFrame.addView(newLayout)
        }
    }

    private fun drawNavigationBar() {
        val navigationBar: LinearLayout = findViewById(R.id.navigation_layout)
        navigationBar.removeAllViews()

        for (i in iconButtons.indices) {
            val btnContainer = LinearLayout(this)
            btnContainer.orientation = LinearLayout.VERTICAL

            val icon = ImageView(this).apply {
                val iconResource = if (i == selected) 2 else 1
                setImageResource(iconButtons[i][iconResource] as Int)
                layoutParams = LinearLayout.LayoutParams(
                    120, 120
                ).apply {
                    gravity = Gravity.CENTER
                    setMargins(50, 20, 50, 20)
                }
            }

            val text = TextView(this).apply {
                text = iconButtons[i][0] as String
                textSize = 14f
                gravity = Gravity.CENTER
                setTypeface(null, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(
                    this@MainScreenActivity,
                    if (i == selected) R.color.primary else R.color.white
                ))
            }

            btnContainer.addView(icon)
            btnContainer.addView(text)

            btnContainer.setOnClickListener {
                switchScreens(i)
            }

            navigationBar.addView(btnContainer)
        }
    }

}