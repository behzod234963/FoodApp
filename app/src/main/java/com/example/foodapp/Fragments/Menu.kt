package com.example.foodapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.Adapters.FoodListAdapter
import com.example.foodapp.Constants.MAIN
import com.example.foodapp.DataBase.FoodsRepository
import com.example.foodapp.Models.DBModel
import com.example.foodapp.R

class Menu : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val views= inflater.inflate(R.layout.fragment_menu,container,false)

        val rvMenu:RecyclerView?=views?.findViewById(R.id.rvFoodList)
        rvMenu?.layoutManager=LinearLayoutManager(requireContext())
        rvMenu?.adapter=FoodListAdapter()
        val list:ArrayList<DBModel>
        val foodAdapter=FoodListAdapter()
        val foodsRepository= FoodsRepository(requireActivity().application)
        list=foodsRepository.getAllFood() as ArrayList<DBModel>
        foodAdapter.submitList(list)
        val btnClose:Button=views.findViewById(R.id.btnCancel_fr)

        val bundle=Bundle()

        foodAdapter.onClick={

            val frDetails=Details()
            val id = list[it].id
            bundle.putInt("id",id!!)
            frDetails.arguments= Bundle()
            MAIN.navController.navigate(R.id.action_menu_to_details)

        }
        btnClose.setOnClickListener {

            MAIN.navController.navigate(R.id.action_menu_to_mainFragment)

        }

        return views

    }

}