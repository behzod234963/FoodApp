package com.example.foodapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.foodapp.Constants.MAIN
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)

    }

    private fun initView(view: View) {

        binding.btnAddMain.setOnClickListener {

            MAIN.navController.navigate(R.id.action_mainFragment_to_addFood)

        }
        binding.btnMenuMain.setOnClickListener {

            MAIN.navController.navigate(R.id.action_mainFragment_to_menu)

        }

    }

}