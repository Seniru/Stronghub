package com.seniru.stronghub.ui

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginEnd
import androidx.core.view.marginRight
import androidx.core.view.setMargins
import androidx.core.view.size
import com.seniru.stronghub.R

class ContestView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private val contestNameTextView: TextView
    private val contestDateTextView: TextView
    private val contestLocationTextView: TextView
    private val contestCategoryTextView: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.contests_layout, this, true)

        contestNameTextView = findViewById(R.id.contestName)
        contestDateTextView = findViewById(R.id.contestDate)
        contestLocationTextView = findViewById(R.id.contestLocation)
        contestCategoryTextView = findViewById(R.id.contestCategory)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ContestStyle,
            0, 0
        ).apply {
            try {
                contestNameTextView.text = getString(R.styleable.ContestStyle_contestName)
                contestDateTextView.text = getString(R.styleable.ContestStyle_contestDate)
                contestLocationTextView.text = getString(R.styleable.ContestStyle_contestLocation)
                contestCategoryTextView.text = getString(R.styleable.ContestStyle_contestCategory)

                val lastRow: LinearLayout = findViewById(R.id.contestLastRow)
                if (getBoolean(R.styleable.ContestStyle_contestCompleted, false)) {

                    val contestWinnerView = TextView(context).apply {
                        text = getString(R.styleable.ContestStyle_contestWinner)
                        setTextColor(getResources().getColor(R.color.black))
                        textSize = 14f

                        layoutParams =
                            LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
                    }

                    val medalImageView = ImageView(context).apply {
                        setImageDrawable(getResources().getDrawable(R.drawable.icon_gold_medal))
                        layoutParams =
                            LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply {
                                width = contestWinnerView.textSize.toInt() + 5
                                height = contestWinnerView.textSize.toInt() + 5
                                setMargins(0, 0, 5, 0)
                            }
                    }

                    val contestWinnerCountryImageView = ImageView(context).apply {
                        setImageDrawable(getDrawable(R.styleable.ContestStyle_contestWinnerCountryImage))
                        gravity = Gravity.BOTTOM
                        layoutParams =
                            LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply {
                                width = 50
                                height = 40
                                setMargins(0, 0, 5, 0)
                            }
                    }
                    lastRow.addView(medalImageView)
                    lastRow.addView(contestWinnerCountryImageView)
                    lastRow.addView(contestWinnerView)
                } else {
                    val subscribeTextView = TextView(context).apply {
                        text = " Subscribe for contest notifications"
                        setTypeface(null, Typeface.BOLD)
                        setTextColor(getResources().getColor(R.color.primary))
                        textSize = 14f
                        layoutParams = LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f)
                    }
                    val bellIcon = ImageView(context).apply {
                        setImageResource(R.drawable.icon_bell)
                        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply {
                            width = subscribeTextView.textSize.toInt() + 5
                            height = subscribeTextView.textSize.toInt() + 5
                        }
                    }
                    lastRow.addView(bellIcon)
                    lastRow.addView(subscribeTextView)

                }

            } finally {
                recycle()
            }
        }
    }

}