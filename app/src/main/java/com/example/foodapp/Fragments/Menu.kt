package com.example.foodapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.Adapters.FoodListAdapter
import com.example.foodapp.DataBase.FoodsRepository
import com.example.foodapp.Models.DBModel
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentMenuBinding

class Menu : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private lateinit var list: ArrayList<DBModel>
    private lateinit var adapter: FoodListAdapter
    private lateinit var repository: FoodsRepository
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadlist()
    }
    private fun loadlist() {
        list = ArrayList()
        repository=FoodsRepository(requireActivity().application)
        list = repository.getAllFood() as ArrayList<DBModel>
        initView()
    }
    private fun initView() {
        binding.rvFoodList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = FoodListAdapter(list,requireContext())
        binding.rvFoodList.adapter = adapter
        repository = FoodsRepository(requireActivity().application)
        adapter.submitList(list)

        adapter.onClick={

            val details=Details()
            val bundle=Bundle()
            val id = list[it].id
            if (id != null) {
                bundle.putInt("id",id)
            }
            details.arguments=bundle
            findNavController().navigate(R.id.action_menu_to_details)

        }

    }

}