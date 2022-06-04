package com.ankhi.weather.adapter

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.ankhi.weather.getFormattedDate
import com.ankhi.weather.icon_prefix
import com.ankhi.weather.icon_suffix
import com.bumptech.glide.Glide

@BindingAdapter("app:setWeatherIcon")
fun setIcon(imageView: ImageView, icon: String?) {
    icon?.let {
        val url = "$icon_prefix$icon$icon_suffix"
        Glide
            .with(imageView.context)
            .load(url)
            .into(imageView)
    }

}

@BindingAdapter("app:setDateTime")
fun setDateTime(textView: TextView, dt: Long) {
    textView.text = getFormattedDate(dt, "MMM dd, yyyy HH:mm")
}

@BindingAdapter("app:setWeekdayTime")
fun setWeekdayTime(textView: TextView, dt: Long) {
    textView.text = getFormattedDate(dt, "EEE, HH:mm")
}