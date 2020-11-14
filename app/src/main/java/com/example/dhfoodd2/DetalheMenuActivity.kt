package com.example.dhfoodd2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dhfoodd2.HomeActivity.Companion.KEY_INTENT_PLACE
import com.google.android.material.shadow.ShadowRenderer

class DetalheMenuActivity : AppCompatActivity() {

    private val ivDestaque by lazy {
        findViewById<ImageView>(R.id.ivDestaque)
    }

    private val ivDetalheBack by lazy {
        findViewById<ImageView>(R.id.ivDetalheBack)
    }

    private val tvDestaqueName by lazy {
        findViewById<TextView>(R.id.tvDestaqueName)
    }

    private var place: Places? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_menu)

        place = intent.getParcelableExtra<Places>(KEY_INTENT_PLACE)

        initComponents()
    }

    private fun initComponents(){

        val menus =mutableListOf<Menus>()
        val menuEscolha = mutableListOf<Menus>()

        val menu1 = Menus("Carlos Pizza","PALERMO","https://wearepalermo.com/wp-content/uploads/2017/06/best-pizza-palermo.jpg","Berinjela assada, molho de tomate, pesto & azeitona (acompanha pão da casa)")
        val menu2 = Menus("Carlos Pizza","PUGLIA","https://media-cdn.tripadvisor.com/media/photo-s/10/4d/d3/53/pizza-puglia.jpg","Cremosa burrata servida com pesto de manjericão (acompanha pão da casa)")
        val menu3 = Menus("Carlos Pizza","QUATRO QUEIJOS","https://abrilmdemulher.files.wordpress.com/2017/11/pizza-quatro-queijos-comitc3aa-umami.jpg?","Muçarela, ricota de búfula, gorgonzola & parmesão")
        val menu4 = Menus("Carlos Pizza","FRANCESCA","https://www.francescaspizzas.com/wp-content/uploads/2014/08/amici-pizza-300x187.jpg","Mozzarella de búfula, nduja (salame típico calabrês) , parmesão & cebola roxa")
        val menu5 = Menus("Carlos Pizza","AMATRICIANA","https://www.silviocicchi.com/pizzachef/wp-content/uploads/2016/01/Amatriciana.jpg","Panceta artesanal, queijo de ovelha, muçarela, cebola roxa, parmesão & orégano")
        val menu6 = Menus("Carlos Pizza","CALABRESA","https://media-cdn.tripadvisor.com/media/photo-s/0d/92/72/10/pizza-de-calabresa-especial.jpg","Muçarela, cebola,parmesão & azeitona")
        val menu7 = Menus("Bráz Elettrica","CAJUPIRY","https://vejasp.abril.com.br/wp-content/uploads/2020/10/f545038c-2e3d-428e-98b7-5f7e5f74a6c9-1600793322109-copy.jpg.jpg","Molho de tomate, orégano, alho, manjericão, cogumelo, cebola roxa, parmesão vegano, cajupiry")
        val menu8 = Menus("Bráz Elettrica","PEPPERONI","https://vejasp.abril.com.br/wp-content/uploads/2019/08/calabresa-piccante.jpg","Molho de tomate, mozzarella, pepperoni")
        val menu9 = Menus("Bráz Elettrica","COBRAVERDE","https://cultura.estadao.com.br/blogs/crop/1200x900/divirta-se/wp-content/uploads/sites/265/2019/07/8-Br%C3%A1z-Elettrica-pizza-cobra-verde-Bruno-Geraldi.jpg","Mozzarella de Búfala, rúcula temperada, parmesão.")
        val menu10 = Menus("Bráz Elettrica","COBRAVERDE","https://cultura.estadao.com.br/blogs/crop/1200x900/divirta-se/wp-content/uploads/sites/265/2019/07/8-Br%C3%A1z-Elettrica-pizza-cobra-verde-Bruno-Geraldi.jpg","Mozzarella de Búfala, rúcula temperada, parmesão.")
        val menu11 = Menus("Bráz Elettrica","COBRAVERDE","https://cultura.estadao.com.br/blogs/crop/1200x900/divirta-se/wp-content/uploads/sites/265/2019/07/8-Br%C3%A1z-Elettrica-pizza-cobra-verde-Bruno-Geraldi.jpg","Mozzarella de Búfala, rúcula temperada, parmesão.")
        val menu12 = Menus("Bráz Elettrica","COBRAVERDE","https://cultura.estadao.com.br/blogs/crop/1200x900/divirta-se/wp-content/uploads/sites/265/2019/07/8-Br%C3%A1z-Elettrica-pizza-cobra-verde-Bruno-Geraldi.jpg","Mozzarella de Búfala, rúcula temperada, parmesão.")
        val menu13 = Menus("Da Mocca Pizza Shop","COBRAVERDE","https://cultura.estadao.com.br/blogs/crop/1200x900/divirta-se/wp-content/uploads/sites/265/2019/07/8-Br%C3%A1z-Elettrica-pizza-cobra-verde-Bruno-Geraldi.jpg","Mozzarella de Búfala, rúcula temperada, parmesão.")
        val menu19 = Menus("Rossopomodoro","Salsicciotta","https://scontent-lga3-1.cdninstagram.com/v/t51.2885-15/e35/125186515_3843181645693268_6872567793796019419_n.jpg?_nc_ht=scontent-lga3-1.cdninstagram.com&_nc_cat=108&_nc_ohc=25WTFRm7bT8AX-Vlph4&tp=18&oh=73dcfb045d365b945e9922ca655e3827&oe=5FD9DBAF","Molho de tomate, linguica artesanal caseira cogumelos")

        menus.add(menu1)
        menus.add(menu2)
        menus.add(menu3)
        menus.add(menu4)
        menus.add(menu5)
        menus.add(menu6)
        menus.add(menu7)
        menus.add(menu8)
        menus.add(menu8)
        menus.add(menu9)
        menus.add(menu10)
        menus.add(menu11)
        menus.add(menu12)
        menus.add(menu13)
        menus.add(menu19)

        menus.forEach {
            if (it.menuPlaceName.equals(place?.placeName)){
                menuEscolha.add(it)
            }
        }

        Glide.with(this)
                .load(place?.placeImage)
                .into(ivDestaque)
        tvDestaqueName.text = place?.placeName

        findViewById<RecyclerView>(R.id.rvDetalheMenuList).apply{
            layoutManager = GridLayoutManager(this@DetalheMenuActivity,2,GridLayoutManager.VERTICAL,true)
            adapter = MenuAdapter(menuEscolha) { position ->
//            val intent = Intent(this@HomeActivity, RegisterActivity::class.java)
//            intent.putExtra(KEY_INTENT_PLACE,places[position])
//            startActivity(intent)
            }
        }

        ivDetalheBack.setOnClickListener{
            finish()
        }
    }
}

