package com.desafio.dhfoodd2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 3000
    private lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initComponent()

        Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, LoginActivity::class.java))

                // close this activity
                finish()
        }, SPLASH_TIME_OUT)
    }

    private fun initComponent(){

        imageView = findViewById<ImageView>(R.id.imageView)

        Glide.with(this)
                .load("https://img.cybercook.com.br/imagens/receitas/619/massa-de-pizza-para-microondas-2.jpeg")
//                .load ("https://media1.giphy.com/media/3o7bu8sRnYpTOG1p8k/giphy.gif?cid=ecf05e476d6ee687ee170ab59f4c901a1c4b301dd440ab34&rid=giphy.gif")
                .override(650,1250)
                .centerCrop()
                .into(imageView)
    }
}
