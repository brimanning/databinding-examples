package com.brimanning.mydatabinding

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("intText")
fun TextView.intText(value: Int?) {
    text = value.toString()
}