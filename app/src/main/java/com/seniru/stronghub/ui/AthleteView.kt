package com.seniru.stronghub.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.seniru.stronghub.R

class AthleteView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private val countryImageView: ImageView
    private val athleteNameView: TextView

    init {

        LayoutInflater.from(context).inflate(R.layout.athlete_layout, this, true)

        countryImageView = findViewById(com.seniru.stronghub.R.id.countryImage)
        athleteNameView = findViewById(R.id.athleteName)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MediaStyle,
            0, 0
        ).apply {
            try {
                val typedArray =
                    context.theme.obtainStyledAttributes(attrs, R.styleable.AthleteCardStyle, 0, 0)
                countryImageView.setImageDrawable(typedArray.getDrawable(R.styleable.AthleteCardStyle_countryImage))
                athleteNameView.text =
                    typedArray.getString(R.styleable.AthleteCardStyle_athleteName) ?: "No name"
            } finally {
                recycle()
            }
        }
    }

}