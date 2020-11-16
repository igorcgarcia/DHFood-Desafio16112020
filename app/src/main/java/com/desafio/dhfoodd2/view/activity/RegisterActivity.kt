package com.desafio.dhfoodd2.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.desafio.dhfoodd2.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {

    private val btRegister by lazy {
        findViewById<Button>(R.id.btRegister)
    }

    private val edRegisterName by lazy {
        findViewById<TextInputEditText>(R.id.edRegisterName)
    }

    private val tfRegisterName by lazy {
        findViewById<TextInputLayout>(R.id.tfRegisterName)
    }

    private val edRegisterEmail by lazy {
        findViewById<TextInputEditText>(R.id.edRegisterEmail)
    }

    private val tfRegisterEmail by lazy {
        findViewById<TextInputLayout>(R.id.tfRegisterEmail)
    }

    private val edRegisterPwd by lazy {
        findViewById<TextInputEditText>(R.id.edRegisterPwd)
    }

    private val tfRegisterPwd by lazy {
        findViewById<TextInputLayout>(R.id.tfRegisterPwd)
    }

    private val edRegisterRPwd by lazy {
        findViewById<TextInputEditText>(R.id.edRegisterRPwd)
    }

    private val tfRegisterRPwd by lazy {
        findViewById<TextInputLayout>(R.id.tfRegisterRPwd)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setupObservables()

    }

    private fun setupObservables(){

        btRegister.setOnClickListener(){
            val name = edRegisterName.text.toString()
            val email = edRegisterEmail.text.toString()
            val pwd = edRegisterPwd.text.toString()
            val rpwd = edRegisterRPwd.text.toString()
            var isValid = true

            if (name.isBlank()){
                edRegisterName.error = getString(R.string.errorMessage,getString(R.string.nameText))
                isValid = false
            } else {
                tfRegisterName.isErrorEnabled = false
            }

            if (email.isBlank()){
                edRegisterEmail.error = getString(R.string.errorMessage,getString(R.string.emailText))
                isValid = false
            } else {
                tfRegisterEmail.isErrorEnabled = false
            }

            if (pwd.isBlank()) {
                edRegisterPwd.error = getString(R.string.errorMessage,getString(R.string.passwordText))
                isValid = false
            } else {
                tfRegisterPwd.isErrorEnabled = false
            }

            if (rpwd.isBlank()){
                edRegisterRPwd.error = getString(R.string.errorMessage,getString(R.string.passwordText))
                isValid = false
            } else {
                tfRegisterRPwd.isErrorEnabled = false
            }

            if (rpwd.equals(pwd)){
                tfRegisterRPwd.isErrorEnabled = false
            } else {
                edRegisterRPwd.error = getString(R.string.errorMessagePwd)
                isValid = false
            }

            if (isValid) {
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }

    }

}

