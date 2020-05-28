package com.rozdoum.baseformvalidationdatabinding.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rozdoum.baseformvalidationdatabinding.databinding.LoginFragmentBinding
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var mainFragmentBinding: LoginFragmentBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainFragmentBinding = LoginFragmentBinding.inflate(inflater, container, false)
        return mainFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        initUI()
        viewModel.emailErrorObservable.observe(viewLifecycleOwner, Observer { error ->
            emailLayout.error = error?.let { getString(error) }
        })

        viewModel.passwordErrorObservable.observe(viewLifecycleOwner, Observer { error ->
            passwordLayout.error = error?.let { getString(error) }
        })

        viewModel.isFormValidObservable.observe(viewLifecycleOwner, Observer { isFormValid ->
            loginButton.isEnabled = isFormValid
        })

    }

    private fun initUI() {
        mainFragmentBinding.email.doAfterTextChanged {
            viewModel.email = it.toString()
        }

        mainFragmentBinding.password.doAfterTextChanged {
            viewModel.password = it.toString()
        }

        mainFragmentBinding.email.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.isEmailValid(true)
            }
        }

        mainFragmentBinding.password.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.isPasswordValid(true)
            }
        }
    }


}
