package com.brimanning.mydatabinding

import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val count = MutableLiveData<Int>()
    val entryValue = MutableLiveData<String>()

    val flipFlop = MutableLiveData<@StringRes Int>()

    init {
        count.value = 0
        flipOrFlop()
    }

    fun incrementCount() {
        count.value = count.value?.inc()
    }

    private fun flipOrFlop() {
        if (flipFlop.value == R.string.flip) {
            flipFlop.value = R.string.flop
        } else {
            flipFlop.value = R.string.flip
        }

        viewModelScope.launch {
            delay(5000)
            flipOrFlop()
        }
    }
}