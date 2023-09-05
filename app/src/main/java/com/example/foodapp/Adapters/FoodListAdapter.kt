package com.example.foodapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.Models.DBModel
import com.example.foodapp.R

class FoodListAdapter(list: ArrayList<DBModel>, requireContext: Context) :RecyclerView.Adapter<FoodListAdapter.FoodListViewHolder>() {
    var onClick:((Int)->Unit)?=null
    var list: ArrayList<DBModel> =ArrayList()
        set(value){
            field=value
            notifyDataSetChanged()
        }
    fun submitList(list: ArrayList<DBModel>){

        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_food_list,parent,false)
        return FoodListViewHolder(view)
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
