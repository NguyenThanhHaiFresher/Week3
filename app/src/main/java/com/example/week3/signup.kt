package com.example.week3

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import java.util.regex.Matcher
import java.util.regex.Pattern

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

        password.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val pattern: Pattern
                val matcher: Matcher
                val specialCharacters = "-@%\\[\\}+'!/#$^?:;,\\(\"\\)~`.*=&\\{>\\]<_"
                val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[$specialCharacters])(?=\\S+$).{8,20}$"
                pattern = Pattern.compile(PASSWORD_REGEX)
                matcher = pattern.matcher(password.text.toString())
                val checkPassword = matcher.matches()

                if(checkPassword == true) {
                    signup.isEnabled = true
                }
                else {
                    signup.isEnabled = false
                    password.setError("Invalid Password")
                }

            }

        })

        email.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches())
                    signup.isEnabled = true
                else {
                    signup.isEnabled = false
                    email.setError("Invalid Email")
                }

            }

        })

        signup.setOnClickListener{
            sharedViewModel.saveEmail(email.text.toString())
            sharedViewModel.savePassword(password.text.toString())
            sharedViewModel.saveFullname(fullname.text.toString())
            Navigation.findNavController(view).navigate(R.id.action_signup_to_login)
        }
    }




}