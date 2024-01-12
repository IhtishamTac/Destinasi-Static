package com.example.tutorialdestinasi.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tutorialdestinasi.Models.Destinations
import com.example.tutorialdestinasi.R
import com.example.tutorialdestinasi.databinding.ItemDestinasiBinding

class ListDestinationAdapter(val context : Context, var datas : List<Destinations>) :
RecyclerView.Adapter<ListDestinationAdapter.ListDestinationHolder>() {
    class ListDestinationHolder(val binding : ItemDestinasiBinding) : ViewHolder(binding.root) {
        val thumbnailDestinasi = binding.thumbnailDestinasi
        val namaDestinasi = binding.judulDestinasi
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListDestinationHolder {
        val binding = ItemDestinasiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListDestinationHolder(binding)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ListDestinationHolder, position: Int) {
        val data = datas.get(position)
        with(holder)
        {
            val drawableResourceId = context.resources.getIdentifier(data.foto, "drawable", context.packageName)

            // Log the resource ID for debugging purposes
            Log.d("ListDestinationAdapter", "Drawable Resource ID: $drawableResourceId")
            holder.thumbnailDestinasi.setImageResource(drawableResourceId)
            holder.namaDestinasi.text = data.name
        }
    }

}
