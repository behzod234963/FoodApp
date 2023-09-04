package com.example.foodapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.Models.DBModel
import com.example.foodapp.Models.FoodListModel
import com.example.foodapp.R

class FoodListAdapter() :RecyclerView.Adapter<FoodListAdapter.FoodListViewHolder>() {


    var list: ArrayList<DBModel> = ArrayList()
    fun submitList(list: ArrayList<DBModel>){

        this.list=list
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()

    }

    var onClick:((Int)->Unit)?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder {

        return FoodListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_food_list,parent,false))

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FoodListViewHolder, position: Int) {

        holder.tvTitle.text= list[position].name
        holder.llTitle.setOnClickListener {

            onClick?.invoke(position)

        }

    }

    class FoodListViewHolder(view:View):RecyclerView.ViewHolder(view){

        val tvTitle:TextView=view.findViewById(R.id.tvText_item)
        val llTitle:LinearLayout=view.findViewById(R.id.llTitle)

    }

}
