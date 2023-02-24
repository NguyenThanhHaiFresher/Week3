package com.example.week3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation


class Profile : Fragment() {

    private lateinit var sharedViewModel:SharedViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val profile = view.findViewById<TextView>(R.id.profilename)
        val fullname = view.findViewById<EditText>(R.id.fullname)
        val email = view.findViewById<EditText>(R.id.email)

        val sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        sharedViewModel.email.observe(viewLifecycleOwner, Observer {
            email.setText(it)
        })
        sharedViewModel.fullname.observe(viewLifecycleOwner, Observer {
            fullname.setText(it)
            profile.text = it
        })

        val update = view.findViewById<Button>(R.id.change_btn)
        update.setOnClickListener{
            sharedViewModel.saveEmail(email.text.toString())
            sharedViewModel.saveFullname(fullname.text.toString())
            Navigation.findNavController(view).navigate(R.id.action_profile_to_login)
            Toast.makeText(activity,"Profile Updated", Toast.LENGTH_SHORT).show()
        }

    }

}