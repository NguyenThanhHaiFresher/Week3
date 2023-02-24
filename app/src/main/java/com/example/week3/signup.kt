package com.example.week3

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation

class signup : Fragment() {


    
    private lateinit var sharedViewModel:SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val signup = view.findViewById<Button>(R.id.signup_btn)
        val fullname = view.findViewById<EditText>(R.id.fullname)
        val email = view.findViewById<EditText>(R.id.email)
        val password = view.findViewById<EditText>(R.id.password)

        val sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        signup.setOnClickListener{
            sharedViewModel.saveEmail(email.text.toString())
            sharedViewModel.savePassword(password.text.toString())
            sharedViewModel.saveFullname(fullname.text.toString())
            Navigation.findNavController(view).navigate(R.id.action_signup_to_login)
        }
    }


}