package com.projetbidouillekotlin.ui.img

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImgViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Image Fragment"
    }
    val text: LiveData<String> = _text
}