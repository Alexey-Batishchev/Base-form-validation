package com.rozdoum.baseformvalidationdatabinding.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rozdoum.baseformvalidationdatabinding.base.validation.Validator

class LoginViewModel : ViewModel() {
    var email: String? = null
    set(value) {
        field = value
        // this line for validate form after each symbol
        //isEmailValid(true)
        isFormValid()
    }

    val emailErrorObservable = MutableLiveData<Int?>()

    var password: String? = null
        set(value) {
            field = value
            // this line for validate form after each symbol
            //isPasswordValid(true)
            isFormValid()
        }
    val passwordErrorObservable = MutableLiveData<Int?>()

    val isFormValidObservable = MutableLiveData(false)


    fun isEmailValid(showError: Boolean): Boolean {
        val email = email
        val result = Validator.validateEmail(email)

        if (showError) {
            emailErrorObservable.postValue(result.errorRes)
        }

        return result.isValid
    }

    fun isPasswordValid(showError: Boolean): Boolean {
        val result = Validator.validatePassword(password)

        if (showError) {
            passwordErrorObservable.postValue(result.errorRes)
        }

        return result.isValid
    }

    private fun isFormValid(): Boolean {
        var isValid = isEmailValid(false)
        isValid = isPasswordValid(false) && isValid

        isFormValidObservable.postValue(isValid)
        return isValid
    }


}
