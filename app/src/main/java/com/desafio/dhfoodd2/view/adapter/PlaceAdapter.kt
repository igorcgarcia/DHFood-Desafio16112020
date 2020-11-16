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
import com.desafio.dhfoodd2.model.Places
//import com.example.dhfoodd2.R


class PlaceAdapter(private val placeList: List<Places>,
                   private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_list_places, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(placeList[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private lateinit var placeImage: ImageView
        private lateinit var placeName: TextView
        private lateinit var placeAddress: TextView
        private lateinit var placeClose: TextView
        private lateinit var mainListContainer: ConstraintLayout


        fun bind(place: Places, onItemClicked: (Int) -> Unit) = with(itemView){

            placeImage = findViewById<ImageView>(R.id.ivListProduct)
            placeName = findViewById<TextView>(R.id.tvListName)
            placeAddress = findViewById<TextView>(R.id.tvListAddress)
            placeClose = findViewById<TextView>(R.id.tvListClose)
            mainListContainer = findViewById<ConstraintLayout>(R.id.mainListContainer)

            Glide.with(itemView.context).load(place.placeImage).into(placeImage)
            placeName.text = place.placeName
            placeAddress.text = place.placeAddress
            placeClose.text = place.placeClose

            mainListContainer.setOnClickListener {
                onItemClicked(this@ViewHolder.adapterPosition)
            }

        }

//            MainContainer.setOnClickListener(){
//                onItemClicked(this@ViewHolder.adapterPosition)
//        }

    }
}


