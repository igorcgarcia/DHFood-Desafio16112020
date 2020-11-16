package com.desafio.dhfoodd2.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.desafio.dhfoodd2.R

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 5000
    private lateinit var ivSplashScreen : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initComponent()

        Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
        }, SPLASH_TIME_OUT)
    }

    private fun initComponent(){

        ivSplashScreen = findViewById<ImageView>(R.id.ivSplashScreen)

        Glide.with(this)
                .load("https://img.cybercook.com.br/imagens/receitas/619/massa-de-pizza-para-microondas-2.jpeg")
                .override(650,1250)
                .centerCrop()
                .into(ivSplashScreen)
    }
}
