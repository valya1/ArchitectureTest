package com.example.multimedia

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.androidarchtesting.R
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_multimedia.*

class MultimediaFragment1 : Fragment(R.layout.fragment_multimedia) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        multimediaMainText.text = navArgs<MultimediaFragment1Args>().value.args.text
    }

    @Parcelize
    data class Args(val text: String, val int: Int) : Parcelable
}

interface ArgsFragment<TArgs : Parcelable>