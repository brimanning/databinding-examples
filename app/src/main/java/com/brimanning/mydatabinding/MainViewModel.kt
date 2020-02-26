package com.brimanning.mydatabinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    fun incrementCount() {
        count.value = count.value?.inc()
    }
}