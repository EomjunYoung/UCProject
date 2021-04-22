package com.example.ucproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ucproject.R

class FragmentThree : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ):
            View? {
        // Inflate the layout for this fragment3
        return inflater.inflate(R.layout.item_more_detail, container, false) }


}