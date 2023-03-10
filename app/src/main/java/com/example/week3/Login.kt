package com.example.week3

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation


class Login : Fragment() {
    private lateinit var sharedViewModel:SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val signin = view.findViewById<Button>(R.id.login_btn)
        val email = view.findViewById<EditText>(R.id.email)
        val password = view.findViewById<EditText>(R.id.password)
        var checkemail = 0
        var checkpassword = 0
        val sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        signin.setOnClickListener{
            sharedViewModel.email.observe(viewLifecycleOwner, Observer {
                if (email.text.toString() == it ) {
                    checkemail = 1
                }
            })
            sharedViewModel.password.observe(viewLifecycleOwner, Observer {
                if (password.text.toString() == it) {
                    checkpassword = 1
                }
            })

            if(email.text.isNullOrBlank() && password.text.isNullOrBlank()){
                Toast.makeText(activity,"Email or Password cannot be blanked", Toast.LENGTH_SHORT).show()
            }
            else if(checkemail == 1 && checkpassword == 1){
                Navigation.findNavController(view).navigate(R.id.action_login_to_menu3)
            }
            else {
                Toast.makeText(activity,"Wrong Email or Password", Toast.LENGTH_SHORT).show()
            }
        }


    }








}