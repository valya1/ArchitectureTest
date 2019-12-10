package com.example.androidarchtesting

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class BaseFragment : Fragment() {

    val navController: NavController
        get() = Navigation.findNavController(activity!!, R.id.hostFragment)

}