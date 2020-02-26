package com.brimanning.mydatabinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val count = MutableLiveData<Int>()
    val entryValue = MutableLiveData<String>()

    init {
        count.value = 0
    }

    fun incrementCount() {
        count.value = count.value?.inc()
    }
}