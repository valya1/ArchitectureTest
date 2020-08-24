package com.example.science

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidarchtesting.R
import com.example.science.science2.ScienceFragment2
import kotlinx.android.synthetic.main.fragment_science.*

class ScienceFragment1 : Fragment(R.layout.fragment_science) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text.text = "Science 1"
        toScience2.setOnClickListener {
            findNavController().navigate(
                ScienceFragment1Directions.actionScienceFragment1ToScienceFragment2(
                    ScienceFragment2.Args("Science 2")
                )
            )
        }

    }
}