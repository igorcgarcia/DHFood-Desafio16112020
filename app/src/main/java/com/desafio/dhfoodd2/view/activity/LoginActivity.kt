package com.desafio.dhfoodd2.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.desafio.dhfoodd2.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private val btMainRegister by lazy {
        findViewById<Button>(R.id.btMainRegister)
    }

    private val btMainLogin by lazy {
        findViewById<Button>(R.id.btMainLogin)
    }

    private val tfMainEmail by lazy {
        findViewById<TextInputLayout>(R.id.tfMainEmail)
    }

    private val edMainEmail by lazy {
        findViewById<TextInputEditText>(R.id.edMainEmail)
    }

    private val tfMainPwd by lazy {
        findViewById<TextInputLayout>(R.id.tfMainPwd)
    }

    private val edMainPwd by lazy {
        findViewById<TextInputEditText>(R.id.edMainPwd)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initComponents()
        setupObservables()
    }

    private fun initComponents(){

        btMainLogin.setOnClickListener(){
            startActivity(Intent(this, HomeActivity::class.java))
        }

        btMainRegister.setOnClickListener(){
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun setupObservables(){

        btMainLogin.setOnClickListener(){
            val email = edMainEmail.text.toString()
            val pwd = edMainPwd.text.toString()
            var isValid = true

            if (email.isBlank()){
                edMainEmail.error =getString(R.string.errorMessage,getString(R.string.emailText))
                isValid = false
            } else {
                tfMainEmail.isErrorEnabled = false
            }

            if (pwd.isBlank()){
                edMainPwd.error =getString(R.string.errorMessage,getString(R.string.passwordText))
                isValid = false
            } else {
                tfMainPwd.isErrorEnabled = false
            }

            if (isValid) {
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }

    }
}