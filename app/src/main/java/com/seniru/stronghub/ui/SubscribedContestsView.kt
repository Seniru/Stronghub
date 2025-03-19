package com.seniru.stronghub.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

import com.seniru.stronghub.R


class SubscribedContestsView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private val headingText: TextView
    private val startDateText: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.subscribed_contests_layout, this, true)

        headingText = findViewById(R.id.heading)
        startDateText = findViewById(R.id.startDate)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.SubscribedContestsStyle,
            0, 0
        ).apply {
            try {
                headingText.text = getString(R.styleable.SubscribedContestsStyle_heading)
                startDateText.text = getString(R.styleable.SubscribedContestsStyle_startDate)
            } finally {
                recycle()
            }
        }
    }

}