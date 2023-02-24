package com.example.week3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
//    private var _fullname = MutableLiveData("Thanhhai")
//    val fullname: LiveData<String> = _fullname
//
//    private var _email = MutableLiveData("thanhhai@gmail.com")
//    val email: LiveData<String> = _email
//
//    private var _password = MutableLiveData("123")
//    val password: LiveData<String> = _password
//
//    fun saveEmail(newEmail: String){
//        _email.value = newEmail
//    }
//
//    fun savePassword(newPassword: String){
//        _password.value = newPassword
//    }

// variable to contain message whenever
// it gets changed/modified(mutable)
    val email = MutableLiveData<String>()
    fun saveEmail(text: String) {
        email.value = text
    }

    val password = MutableLiveData<String>()
    fun savePassword(text: String) {
        password.value = text
    }

    val fullname = MutableLiveData<String>()
    fun saveFullname(text: String){
        fullname.value = text
    }

}