package com.rozdoum.baseformvalidationdatabinding.base.validation

import androidx.annotation.StringRes

/**
 * Created by Alexey on 28.05.20.
 */
data class ValidationResult(
    val isValid: Boolean,
    @StringRes val errorRes: Int? = null
)