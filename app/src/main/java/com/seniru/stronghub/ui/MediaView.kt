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


class MediaView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private val mediaImage: ImageView
    private val headingText: TextView
    private val postedByText: TextView
    private val viewsText: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.media_layout, this, true)

        mediaImage = findViewById(R.id.media_image)
        headingText = findViewById(R.id.media_title)
        postedByText = findViewById(R.id.postedByText)
        viewsText = findViewById(R.id.viewsText)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MediaStyle,
            0, 0
        ).apply {
            try {
                headingText.text = getString(R.styleable.MediaStyle_mediaTitle)

                val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.MediaStyle, 0, 0)
                val views = typedArray.getString(R.styleable.MediaStyle_views) ?: "0"
                val username = typedArray.getString(R.styleable.MediaStyle_username)
                val imageUrl = typedArray.getDrawable(R.styleable.MediaStyle_imageUrl)
                viewsText.text = getResources().getString(R.string.views, views)
                postedByText.text = getResources().getString(R.string.posted_by, username)
                mediaImage.setImageDrawable(imageUrl)

            } finally {
                recycle()
            }
        }
    }



}