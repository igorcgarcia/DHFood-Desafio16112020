package com.desafio.dhfoodd2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.desafio.dhfoodd2.R

class DetalheEscolhaMenuActivity : AppCompatActivity() {

    private val ivMenuDetalheBack by lazy {
        findViewById<ImageView>(R.id.ivMenuDetalheBack)
    }

    private val ivMenuDetalhe by lazy {
        findViewById<ImageView>(R.id.ivMenuDetalhe)
    }

    private val tvMenuDestaqueName by lazy {
        findViewById<TextView>(R.id.tvMenuDestaqueName)
    }

    private val tvMenuDestaqueDescricao by lazy {
        findViewById<TextView>(R.id.tvMenuDestaqueDescricao)
    }



    private var menu: Menus? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_escolha_menu)

        menu = intent.getParcelableExtra<Menus>(DetalheMenuActivity.KEY_INTENT_MENU)

        Glide.with(this)
            .load(menu?.menuImage)
            .into(ivMenuDetalhe)
        tvMenuDestaqueName.text = menu?.menuName
        tvMenuDestaqueDescricao.text = menu?.MenuDescription


        ivMenuDetalheBack.setOnClickListener {
            finish()
        }
    }
}