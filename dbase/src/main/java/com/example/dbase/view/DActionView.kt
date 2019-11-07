package com.example.dbase.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.example.dbase.listener.DActionViewListener
import com.example.dbase.R
import kotlinx.android.synthetic.main.view_d_action.view.*
import kotlinx.android.synthetic.main.view_no_internet.view.*

public class DActionView : RelativeLayout {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        LayoutInflater.from(context).inflate(R.layout.view_d_action, this)
    }

    fun onLoading() {
        layout_loading.visibility = View.VISIBLE
        layout_no_internet.visibility = View.GONE
    }

    fun setNoData(
        buttonRetry: ButtonRetry,
        title: String = "Whoops!",
        message: String = context.getString(R.string.msg_no_data),
        errorDrawable: Int = R.drawable.ic_no_data
    ) {
        displayErrorInformation(title, message, errorDrawable)
        button_retry.text = buttonRetry.name
        button_retry.setOnClickListener {
            buttonRetry.actionViewListener?.onRetryClick()
        }
    }

    fun setNoInternet(
        buttonRetry: ButtonRetry,
        title: String = "Oops!",
        message: String = context.getString(R.string.msg_no_internet),
        errorDrawable: Int = R.drawable.ic_no_internet
    ) {
        displayErrorInformation(title, message, errorDrawable)
        button_retry.text = buttonRetry.name
        button_retry.setOnClickListener {
            buttonRetry.actionViewListener?.onRetryClick()
        }
    }

    private fun displayErrorInformation(
        title: String = "",
        message: String = "",
        errorDrawable: Int
    ) {
        layout_loading.visibility = View.GONE
        layout_no_internet.visibility = View.VISIBLE
        text_view_message_title.text = title
        text_view_message.text = message
        image_view_action.setImageResource(errorDrawable)
    }

    fun hide() {
        visibility = View.GONE
    }

    class ButtonRetry(var name: String = "", var actionViewListener: DActionViewListener? = null)
}