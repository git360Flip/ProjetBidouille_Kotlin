package com.projetbidouillekotlin.ui.write

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WriteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Write Fragment"
    }
    val text: LiveData<String> = _text
}