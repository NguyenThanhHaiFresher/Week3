package com.example.week3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.Navigation


class Onboard1 : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_onboard1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val onboard2btn = view.findViewById<ImageButton>(R.id.Onboard2Button)
        onboard2btn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_onboard1_to_onboard2)
        }
    }


}