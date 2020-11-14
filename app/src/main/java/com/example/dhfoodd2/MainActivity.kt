package com.example.dhfoodd2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private val btMainRegister by lazy {
        findViewById<Button>(R.id.btMainRegister)
    }

    private val btMainLogin by lazy {
        findViewById<Button>(R.id.btMainLogin)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
    }

    private fun initComponents(){

        btMainLogin.setOnClickListener(){
            startActivity(Intent(this,HomeActivity::class.java))
        }

        btMainRegister.setOnClickListener(){
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}