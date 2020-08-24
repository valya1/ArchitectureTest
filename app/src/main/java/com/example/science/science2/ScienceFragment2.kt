package com.example.science.science2

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.androidarchtesting.R
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_science.*

class ScienceFragment2 : Fragment(R.layout.fragment_science) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        text.text = navArgs<Args>().value.text
    }

    @Parcelize
    data class Args(val text: String) : Parcelable
}