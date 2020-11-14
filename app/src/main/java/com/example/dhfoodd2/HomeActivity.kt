package com.example.dhfoodd2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val places = mutableListOf<Places>()

        val place1 = Places("https://img.estadao.com.br/thumbs/640/resources/jpg/4/9/1550710029394.jpg",
                "Carlos Pizza",
                "Rua Harmonia, 501",
                "Diariamente, das 18h às 22h")
        val place2 = Places("https://marcelokatsuki.blogfolha.uol.com.br/files/2019/01/be19-abre.jpg",
                "Bráz Elettrica",
                "Rua Guaicuí, 38 - Pinheiros",
                "Segunda a Quinta, das 18h às 22h")
        val place3 = Places("https://conteudo.imguol.com.br/c/noticias/08/2018/05/17/da-mooca-pizza-shop-pizza-parma-1526579996941_1200x800.jpg",
                "Da Mocca Pizza Shop",
                "RUA Fradique Coutinho, 154",
                "Segunda à Sábado, das 11h às 00h")
        val place4 = Places("https://vejasp.abril.com.br/wp-content/uploads/2017/07/img_5092-jpeg.jpg",
                "Rossopomodoro",
                "Rua Pedroso Alvarenga , 909",
                "Segunda a quinta das 12h às 15h e das 19h às 24h")

        places.add(place1)
        places.add(place2)
        places.add(place3)
        places.add(place4)

        findViewById<RecyclerView>(R.id.rvHomePlaceList).apply{
        layoutManager = LinearLayoutManager(this@HomeActivity)
        adapter = PlaceAdapter(places) {position ->
            val intent = Intent(this@HomeActivity, DetalheMenuActivity::class.java)
            intent.putExtra(KEY_INTENT_PLACE,places[position])
            startActivity(intent)
        }
    }

    }

    companion object{
        const val KEY_INTENT_PLACE = "place"
    }
}