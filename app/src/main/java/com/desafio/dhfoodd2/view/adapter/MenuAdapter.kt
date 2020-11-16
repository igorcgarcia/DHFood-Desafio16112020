package com.desafio.dhfoodd2.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.desafio.dhfoodd2.R
import com.desafio.dhfoodd2.model.Menus

//import com.example.dhfoodd2.R


class MenuAdapter(private val menuList: List<Menus>,
                  private val onItemMenuClicked: (Int) -> Unit
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.secundary_list_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(menuList[position], onItemMenuClicked)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private lateinit var ivProd: ImageView
        private lateinit var ivProdName: TextView

        fun bind(menu: Menus, onItemMenuClicked: (Int) -> Unit) = with(itemView){

            val DetContainer by lazy {
                findViewById<ConstraintLayout>(R.id.DetContainer)
            }


            ivProd = findViewById<ImageView>(R.id.ivDetalheMenuProduto)
            ivProdName = findViewById<TextView>(R.id.ivProdName)

            Glide.with(itemView.context).load(menu.menuImage).into(ivProd)
            ivProdName.text = menu.menuName

            DetContainer.setOnClickListener {
                onItemMenuClicked(this@ViewHolder.adapterPosition)
            }


        }

    }
}
