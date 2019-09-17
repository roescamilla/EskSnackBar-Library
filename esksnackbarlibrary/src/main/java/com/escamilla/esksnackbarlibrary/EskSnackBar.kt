package com.escamilla.esksnackbarlibrary

import android.app.Activity
import android.support.design.widget.BaseTransientBottomBar
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.ViewGroup


class EskSnackBar(
        parent: ViewGroup,
        content: EskSnackBarView
)  : BaseTransientBottomBar<EskSnackBar>(parent, content, content) {

    init {
        getView().setBackgroundColor(ContextCompat.getColor(view.context, android.R.color.transparent))
        getView().setPadding(0, 0, 0, 0)
    }

    companion object {

        fun makeCustom(activity: Activity, message : String, textColor : Int, image : Int): EskSnackBar {

            val view = (activity
                    .findViewById(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup



            val parent = view.parent as (ViewGroup)

            val customView = LayoutInflater.from(view.context).inflate(
                    R.layout.layout_error_snackbar,
                    parent,
                    false
            ) as EskSnackBarView

            customView.messageTextView.text = message
            customView.messageTextView.setTextColor(textColor)
            customView.iconImage.setImageDrawable(ContextCompat.getDrawable(activity, image))

            return EskSnackBar(
                    parent,
                    customView
            )
        }

        fun makeDoneAlert(activity: Activity, message : String, textColor : Int): EskSnackBar {

            val view = (activity
                    .findViewById(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup



            val parent = view.parent as (ViewGroup)

            val customView = LayoutInflater.from(view.context).inflate(
                    R.layout.layout_error_snackbar,
                    parent,
                    false
            ) as EskSnackBarView

            customView.messageTextView.text = message
            customView.messageTextView.setTextColor(textColor)
            customView.iconImage.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_done_circle))

            return EskSnackBar(
                    parent,
                    customView
            )
        }

        fun makeBadAlert(activity: Activity, message : String, textColor : Int): EskSnackBar {

            val view = (activity
                    .findViewById(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup



            val parent = view.parent as (ViewGroup)

            val customView = LayoutInflater.from(view.context).inflate(
                    R.layout.layout_error_snackbar,
                    parent,
                    false
            ) as EskSnackBarView

            customView.messageTextView.text = message
            customView.messageTextView.setTextColor(textColor)
            customView.iconImage.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_bad_request))

            return EskSnackBar(
                    parent,
                    customView
            )
        }

    }

}