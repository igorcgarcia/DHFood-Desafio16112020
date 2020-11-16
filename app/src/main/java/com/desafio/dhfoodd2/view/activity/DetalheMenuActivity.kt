package com.desafio.dhfoodd2.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.desafio.dhfoodd2.R
import com.desafio.dhfoodd2.view.activity.HomeActivity.Companion.KEY_INTENT_PLACE
import com.desafio.dhfoodd2.model.Menus
import com.desafio.dhfoodd2.model.Places
import com.desafio.dhfoodd2.view.adapter.MenuAdapter


class DetalheMenuActivity : AppCompatActivity() {

    private val ivDestaque by lazy {
        findViewById<ImageView>(R.id.ivDetalheMenuDestaque)
    }

    private val ivDetalheBack by lazy {
        findViewById<ImageView>(R.id.ivDetalheMenuBack)
    }

    private val tvDestaqueName by lazy {
        findViewById<TextView>(R.id.tvDetalheMenuDestaqueName)
    }

    private var place: Places? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_menu)

        place = intent.getParcelableExtra<Places>(KEY_INTENT_PLACE)

        initComponents()
    }

    private fun initComponents(){

        val menus = mutableListOf<Menus>()
        val menuEscolha = mutableListOf<Menus>()

        val menu1 = Menus("Carlos Pizza","Palermo","https://wearepalermo.com/wp-content/uploads/2017/06/best-pizza-palermo.jpg","Berinjela assada, molho de tomate, pesto & azeitona (acompanha pão da casa).")
        val menu2 = Menus("Carlos Pizza","Puglia","https://media-cdn.tripadvisor.com/media/photo-s/10/4d/d3/53/pizza-puglia.jpg","Cremosa burrata servida com pesto de manjericão (acompanha pão da casa).")
        val menu3 = Menus("Carlos Pizza","Quatro Queijos","https://abrilmdemulher.files.wordpress.com/2017/11/pizza-quatro-queijos-comitc3aa-umami.jpg?","Muçarela, ricota de búfula, gorgonzola & parmesão.")
        val menu4 = Menus("Carlos Pizza","Francesca","https://www.francescaspizzas.com/wp-content/uploads/2014/08/amici-pizza-300x187.jpg","Mozzarella de búfula, nduja (salame típico calabrês) , parmesão & cebola roxa.")
        val menu5 = Menus("Carlos Pizza","Amatriciana","https://www.silviocicchi.com/pizzachef/wp-content/uploads/2016/01/Amatriciana.jpg","Panceta artesanal, queijo de ovelha, muçarela, cebola roxa, parmesão & orégano.")
        val menu6 = Menus("Carlos Pizza","Calabresa","https://media-cdn.tripadvisor.com/media/photo-s/0d/92/72/10/pizza-de-calabresa-especial.jpg","Muçarela, cebola,parmesão & azeitona.")
        val menu7 = Menus("Bráz Elettrica","Cajupiry","https://vejasp.abril.com.br/wp-content/uploads/2020/10/f545038c-2e3d-428e-98b7-5f7e5f74a6c9-1600793322109-copy.jpg.jpg","Molho de tomate, orégano, alho, manjericão, cogumelo, cebola roxa, parmesão vegano, cajupiry.")
        val menu8 = Menus("Bráz Elettrica","Sr. Falco","https://lembrancasdagabi.files.wordpress.com/2019/02/photo_2019-01-26_17-05-05.jpg","Molho de tomate, linguiça fresca, cebola roxa, alho, manjericão, picles de jalapeño, parmesão.")
        val menu9 = Menus("Bráz Elettrica","Shroomz","https://media-cdn.tripadvisor.com/media/photo-s/13/4b/bf/5d/pizza-shroomz.jpg","Cogumelos assados, mozzarella de búfala, gorgonzola, cebola roxa, alho, limão siciliano.")
        val menu10 = Menus("Bráz Elettrica","Bráz","https://images.squarespace-cdn.com/content/v1/59288f7b29687fd92094821b/1553897079307-1CFFE6XG7ME8HED411G0/ke17ZwdGBToddI8pDm48kAnSLfUT2jb7aRjd3BROz7hZw-zPPgdn4jUwVcJE1ZvWQUxwkmyExglNqGp0IvTJZamWLI2zvYWH8K3-s_4yszcp2ryTI0HqTOaaUohrI8PI1jlexL4PQ5Ck65HRiHBDIvf_1W968p_lYvIBRt3wT5wKMshLAGzx4R3EDFOm1kBS/braz-pizzaria.jpg","Molho de tomate, fatias de abobrinha, mozzarella, alho, parmesão.")
        val menu11 = Menus("Bráz Elettrica","Supreme","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQfJSzpeUMfni4u5dAhcn0-K59yE2s6djOdwA&usqp=CAU","Molho de tomate, mozzarella, pepperoni, cogumelo, cebola roxa, picles de jalapeño.")
        val menu12 = Menus("Bráz Elettrica","Cobravede","https://cultura.estadao.com.br/blogs/crop/1200x900/divirta-se/wp-content/uploads/sites/265/2019/07/8-Br%C3%A1z-Elettrica-pizza-cobra-verde-Bruno-Geraldi.jpg","Mozzarella de Búfala, rúcula temperada, parmesão.")
        val menu13 = Menus("Da Mocca Pizza Shop","Castelões","https://static-images.ifood.com.br/image/upload/t_high/pratos/a7661aa7-88d4-48b3-9081-b5184e212489/202006252153_nC7n_.jpeg","Molho de tomate, mussarela, calabresa artesanal e oregano.")
        val menu14 = Menus("Da Mocca Pizza Shop","Brocolini","https://static-images.ifood.com.br/image/upload/t_high/pratos/a7661aa7-88d4-48b3-9081-b5184e212489/202005111229_Wl0F_.jpeg","Molho de tomate italiano, mozzarella, brócolis, calabresa curada na erva doce pré assada e pimenta preta moída.")
        val menu15 = Menus("Da Mocca Pizza Shop","Calabronx","https://static-images.ifood.com.br/image/upload/t_high/pratos/a7661aa7-88d4-48b3-9081-b5184e212489/202006172017_C86m_.jpeg","Molho de tomate italiano, salame diavoleti artesanal, mussarela artesanal, cebola roxa e manjericão.")
        val menu16 = Menus("Da Mocca Pizza Shop","Marguerita","https://static-images.ifood.com.br/image/upload/t_high/pratos/a7661aa7-88d4-48b3-9081-b5184e212489/202005111219_nNov_m.jpg","Molho de tomate, mozzarella artesanal e manjericão fresco.")
        val menu17 = Menus("Da Mocca Pizza Shop","Portuguesa","https://static-images.ifood.com.br/image/upload/t_high/pratos/a7661aa7-88d4-48b3-9081-b5184e212489/202006172103_6zhB_.jpeg","Molho bechamel, presunto, mussarela, ervilha e cebola roxa, ovo, pimenta do reino e flor de sal.")
        val menu18 = Menus("Da Mocca Pizza Shop","Zucchini","https://static-images.ifood.com.br/image/upload/t_high/pratos/a7661aa7-88d4-48b3-9081-b5184e212489/202006172104_ZdyB_.jpeg","Molho de tomate italiano, abobrinha laminada, mozzarella e finalizada com azeite de alho, pimenta preta moída na hora e flor de sal.")
        val menu19 = Menus("Rossopomodoro","Salsicciotta","https://scontent-lga3-1.cdninstagram.com/v/t51.2885-15/e35/125186515_3843181645693268_6872567793796019419_n.jpg?_nc_ht=scontent-lga3-1.cdninstagram.com&_nc_cat=108&_nc_ohc=25WTFRm7bT8AX-Vlph4&tp=18&oh=73dcfb045d365b945e9922ca655e3827&oe=5FD9DBAF","Molho de tomate, linguica artesanal caseira cogumelos.")
        val menu20 = Menus("Rossopomodoro","Margherita Verace","https://img.estadao.com.br/thumbs/640/resources/jpg/9/5/1512245764359.jpg","Molho de tomate San Marzano, mozzarella de búfala La Bufalina, manjericão fresco e azeite de oliva extravirgem.")
        val menu21 = Menus("Rossopomodoro","Carpaccio Burrata","https://media-cdn.tripadvisor.com/media/photo-s/12/08/dd/0b/bresaola-di-bufalo-carpaccio.jpg","Pizza com molho de tomate, finalizada com carpaccio, burrata e trufa preta.")
        val menu22 = Menus("Rossopomodoro","Tartufata","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSoohQUYVXA3JWhzs4yhSz4_mn-15opaS6Z4Q&usqp=CAU","Molho de tomate, mozzarella, cogumelos guanciale e trufa preta.")
        val menu23 = Menus("Rossopomodoro","A Borboleta","https://ederepente50.files.wordpress.com/2019/11/rosso-pratos-120.jpg?w=604","Forma de borboleta, um lado salame picante e cebola roxa caramelizada, um lado calabresa e parmesão e no centro recheio de ricotta, gorgonzola e provolone.")
        val menu24 = Menus("Rossopomodoro","Mortadella e limone","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ7fs7UIcbLnJHpkJuUvktWnhmU0v7DPLoQyQ&usqp=CAU","Mozzarella, carpaccio di limone, mortadella Bologna IGP, pepe e pistacchi.")

        menus.add(menu1)
        menus.add(menu2)
        menus.add(menu3)
        menus.add(menu4)
        menus.add(menu5)
        menus.add(menu6)
        menus.add(menu7)
        menus.add(menu8)
        menus.add(menu9)
        menus.add(menu10)
        menus.add(menu11)
        menus.add(menu12)
        menus.add(menu13)
        menus.add(menu14)
        menus.add(menu15)
        menus.add(menu16)
        menus.add(menu17)
        menus.add(menu18)
        menus.add(menu19)
        menus.add(menu20)
        menus.add(menu21)
        menus.add(menu22)
        menus.add(menu23)
        menus.add(menu24)

        menus.forEach {

            if (it.menuPlaceName.equals(place?.placeName)){
                menuEscolha.add(it)
            }
        }


        Glide.with(this)
                .load(place?.placeImage)
                .override(540,342)
                .centerInside()
                .into(ivDestaque)
        tvDestaqueName.text = place?.placeName

        findViewById<RecyclerView>(R.id.rvDetalheMenuList).apply{
            layoutManager = GridLayoutManager(this@DetalheMenuActivity,2,GridLayoutManager.VERTICAL,true)
            adapter = MenuAdapter(menuEscolha) { position ->
            val intent = Intent(this@DetalheMenuActivity, DetalheEscolhaMenuActivity::class.java)
            intent.putExtra(KEY_INTENT_MENU,menuEscolha[position])
            startActivity(intent)
            }
        }

        ivDetalheBack.setOnClickListener{
            finish()
        }
    }

    companion object{
        const val KEY_INTENT_MENU = "menu"
    }
}


