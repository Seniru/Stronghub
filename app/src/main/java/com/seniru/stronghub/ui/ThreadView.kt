package com.seniru.stronghub.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.seniru.stronghub.R
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


class ThreadView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private val threadTitleText: TextView
    private val startedByText: TextView
    private val repliesText: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.thread_layout, this, true)

        threadTitleText = findViewById(R.id.threadTitle)
        startedByText = findViewById(R.id.startedByText)
        repliesText = findViewById(R.id.repliesText)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MediaStyle,
            0, 0
        ).apply {
            try {
                val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.ThreadStyle, 0, 0)
                threadTitleText.text = typedArray.getString(R.styleable.ThreadStyle_threadTitle) ?: "No Title"
                val views = typedArray.getString(R.styleable.ThreadStyle_replies) ?: "0"
                val username = typedArray.getString(R.styleable.ThreadStyle_startedBy)
                repliesText.text = getResources().getString(R.string.replies, views)
                startedByText.text = getResources().getString(R.string.started_by, username)

            } finally {
                recycle()
            }
        }
    }



}