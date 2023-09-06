package com.example.foodapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.foodapp.DataBase.FoodsRepository
import com.example.foodapp.Models.DBModel
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentDetailsBinding

class Details : Fragment() {

    val args:DetailsArgs by navArgs()
    lateinit var binding: FragmentDetailsBinding
    var userId=1
    lateinit var foodsRepository: FoodsRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

        userId=args.id
        foodsRepository= FoodsRepository(requireActivity().application)
        binding.tvNameDetails.text=foodsRepository.getFoodByID(userId).toString()

    }

}