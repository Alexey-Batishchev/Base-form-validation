package com.rozdoum.baseformvalidationdatabinding.base.validation

import android.util.Patterns
import com.rozdoum.baseformvalidationdatabinding.R

/**
 * Created by Alexey on 28.05.20.
 */
class Validator {
    companion object {

        fun validateEmail(email: String?): ValidationResult {
            var isValid = true
            var error: Int? = null

            if (email.isNullOrEmpty()) {
                error = R.string.empty_field_error
                isValid = false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()) {
                error = R.string.email_is_incorrect_error
                isValid = false
            }

            return ValidationResult(isValid, error)
        }


        fun validatePassword(password: String?): ValidationResult {
            var isValid = true
            var error: Int? = null

            if (password.isNullOrEmpty()) {
                error = R.string.empty_field_error
                isValid = false
            } else if (password.length < 5) {
                error = R.string.password_min_length_error
                isValid = false
            }

            return ValidationResult(isValid, error)
        }


    }
}
