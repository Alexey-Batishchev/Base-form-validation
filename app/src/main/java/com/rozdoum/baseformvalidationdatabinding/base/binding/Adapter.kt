package com.rozdoum.baseformvalidationdatabinding.base.binding

import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter

/**
 * Created by Alexey on 28.05.20.
 */


@BindingAdapter("onFocus")
fun bindFocusChange(
    editText: EditText,
    onFocusChangeListener: View.OnFocusChangeListener?
) {
    if (editText.onFocusChangeListener == null) {
        editText.onFocusChangeListener = onFocusChangeListener
    }
}