package com.example.mvvm_kotlin_based_nav_component.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvm_kotlin_based_nav_component.R

class CountriesFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("CountriesFragment","onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CountriesFragment","onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("CountriesFragment","onCreateView")
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("CountriesFragment","onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("CountriesFragment","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CountriesFragment","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CountriesFragment","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CountriesFragment","onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("CountriesFragment","onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CountriesFragment","onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("CountriesFragment","onDetach")
    }

}