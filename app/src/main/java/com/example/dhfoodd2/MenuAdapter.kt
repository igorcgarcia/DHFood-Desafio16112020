package com.example.dhfoodd2

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.util.Util
import java.lang.reflect.Array.get
import java.security.AccessController.getContext


class MenuAdapter(private val menuList: List<Menus>,
                  private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.secundary_list_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuAdapter.ViewHolder, position: Int) {
        holder.bind(menuList[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private lateinit var ivProd: ImageView
        private lateinit var ivProdName: TextView

        fun bind(menu: Menus, onItemClicked: (Int) -> Unit) = with(itemView){

            ivProd = findViewById<ImageView>(R.id.ivProd)
            ivProdName = findViewById<TextView>(R.id.ivProdName)

            Glide.with(itemView.context).load(menu.menuImage).into(ivProd)
            ivProdName.text = menu.menuName


//            if (user.userMessagesCount > 0 ) {
//
//                tvLastView.setTextColor(ContextCompat.getColor(context,R.color.green))
//                btMessagesCount.text = user.userMessagesCount.toString()
//                btMessagesCount.isVisible = true
//            }
//
//            MainContainer.setOnClickListener(){
//                onItemClicked(this@ViewHolder.adapterPosition)


        }

    }
}
