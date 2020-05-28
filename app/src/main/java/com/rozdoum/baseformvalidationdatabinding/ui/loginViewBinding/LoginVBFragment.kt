package com.rozdoum.baseformvalidationdatabinding.ui.loginViewBinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rozdoum.baseformvalidationdatabinding.databinding.LoginViewBindingFragmentBinding

class LoginVBFragment : Fragment() {

    companion object {
        fun newInstance() = LoginVBFragment()
    }

    private lateinit var mainFragmentBinding: LoginViewBindingFragmentBinding
    private lateinit var viewModel: LoginVBViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainFragmentBinding = LoginViewBindingFragmentBinding.inflate(inflater, container, false)
        mainFragmentBinding.lifecycleOwner = viewLifecycleOwner
        return mainFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginVBViewModel::class.java)
        mainFragmentBinding.viewModel = viewModel
        // TODO: Use the ViewModel
    }


}
