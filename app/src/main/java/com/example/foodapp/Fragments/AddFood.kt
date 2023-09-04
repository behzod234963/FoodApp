package com.example.foodapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.example.foodapp.Constants.MAIN
import com.example.foodapp.DataBase.FoodsRepository
import com.example.foodapp.Models.DBModel
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentAddFoodBinding

class AddFood : Fragment() {

    lateinit var binding: FragmentAddFoodBinding
    lateinit var foodsRepository: FoodsRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAddFoodBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)

    }

    private fun initView(view: View) {

        foodsRepository=FoodsRepository(requireActivity().application)
        binding.btnCancelFr.setOnClickListener {

            MAIN.navController.navigate(R.id.action_addFood_to_mainFragment)

        }
        binding.btnSaveFrAdd.setOnClickListener {

            foodsRepository.saveFood(
                DBModel(null,
                binding.etFoodNameFrAdd.text.toString(),
                binding.etNProductsFrAdd.text.toString(),
                binding.etMoPFrAdd.text.toString())
            )
            MAIN.navController.navigate(R.id.action_addFood_to_mainFragment)

        }

    }

}