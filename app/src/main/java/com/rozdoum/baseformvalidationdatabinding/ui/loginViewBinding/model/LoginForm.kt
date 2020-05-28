package com.rozdoum.baseformvalidationdatabinding.ui.loginViewBinding.model

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.library.baseAdapters.BR
import com.rozdoum.baseformvalidationdatabinding.base.validation.Validator

/**
 * Created by Alexey on 27.05.20.
 */
class LoginForm : BaseObservable() {

    //email
    var email: String? = null
        set(value) {
            field = value
            // use this line for each symbol enter validation
//            isEmailValid(true)
            notifyPropertyChanged(BR.formValid)
        }

    var emailError = ObservableField<Int?>()

    val onFocusChangeEmail = View.OnFocusChangeListener { _, hasFocus ->
        if (!hasFocus) {
            isEmailValid(true)
        }
    }

    //password
    var password: String? = null
        set(value) {
            field = value
            // use this line for each symbol enter validation
//            isPasswordValid(true)
            notifyPropertyChanged(BR.formValid)
        }

    var passwordError = ObservableField<Int?>()

    val onFocusChangePassword = View.OnFocusChangeListener { _, hasFocus ->
        if (!hasFocus) {
            isPasswordValid(true)
        }
    }


    val isFormValid: Boolean
        @Bindable
        get() {
            return isEmailValid(false) && isPasswordValid(false)
        }


    private fun isEmailValid(showError: Boolean): Boolean {
        val email = email
        val result = Validator.validateEmail(email)

        if (showError) {
            emailError.set(result.errorRes)
        }

        return result.isValid
    }

    private fun isPasswordValid(showError: Boolean): Boolean {
        val result = Validator.validatePassword(password)

        if (showError) {
            passwordError.set(result.errorRes)
        }

        return result.isValid
    }

}