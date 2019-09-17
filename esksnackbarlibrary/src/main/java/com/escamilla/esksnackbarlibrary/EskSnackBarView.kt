package com.escamilla.esksnackbarlibrary

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.design.snackbar.ContentViewCallback
import android.util.AttributeSet
import android.view.View
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.error_snackbar.view.*

class EskSnackBarView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), ContentViewCallback {

    val iconImage: ImageView
    val messageTextView : TextView

    init {
        val view = View.inflate(context, R.layout.error_snackbar, this)
        this.iconImage = ivIcon
        this.messageTextView = tvMessage
        clipToPadding = false

    }

    override fun animateContentIn(delay: Int, duration: Int) {
        val scaleX = ObjectAnimator.ofFloat(iconImage, View.SCALE_X, 0f, 1f)
        val scaleY = ObjectAnimator.ofFloat(iconImage, View.SCALE_Y, 0f, 1f)
        val animatorSet = AnimatorSet().apply {
            interpolator = OvershootInterpolator()
            setDuration(500)
            playTogether(scaleX, scaleY)
        }
        animatorSet.start()
    }

    override fun animateContentOut(delay: Int, duration: Int) {

    }

}