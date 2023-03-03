package com.example.week3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item.view.*

class Adapter(var ds:List<Restaurant>):RecyclerView.Adapter<Adapter.MenuViewHolder>() {
    inner class MenuViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item,parent,false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.itemView.apply {
            IDnumber.text = ds[position].id.toString()
            TenQuan.text = ds[position].name
            Address.text = ds[position].address
            Restaurantimg.setImageResource(ds[position].image)
        }
        
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}