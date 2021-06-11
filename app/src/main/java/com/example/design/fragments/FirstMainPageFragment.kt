package com.example.design.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceControl
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.design.R
import com.example.design.databinding.ActivityMainBinding
import com.example.design.databinding.FragmentFirstMainPageBinding

class FirstMainPageFragment : Fragment(R.layout.fragment_first_main_page_){
    private lateinit var binding: FragmentFirstMainPageBinding
    private lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstMainPageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.profile.setOnClickListener {
            navController.navigate(FirstMainPageFragmentDirections.actionFirstMainPageFragmentToProfilePageFragment())
        }

    }
}