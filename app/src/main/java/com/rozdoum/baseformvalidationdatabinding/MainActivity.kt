package com.rozdoum.baseformvalidationdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rozdoum.baseformvalidationdatabinding.ui.login.LoginFragment
import com.rozdoum.baseformvalidationdatabinding.ui.loginViewBinding.LoginVBFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        login_mvvm.setOnClickListener {
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LoginFragment.newInstance())
                    .commitNow()
            }
        }

        loginVB.setOnClickListener {
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LoginVBFragment.newInstance())
                    .commitNow()
            }
        }

    }
}
