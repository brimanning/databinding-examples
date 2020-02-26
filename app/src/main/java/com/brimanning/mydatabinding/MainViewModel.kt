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

    val flipFlopModel = MutableLiveData<FlipFlopModel>()

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

        if (flipFlopModel.value?.flipFlopString == R.string.flop) {
            flipFlopModel.value = FlipFlopModel(R.string.flip)
        } else {
            flipFlopModel.value = FlipFlopModel(R.string.flop)
        }

        viewModelScope.launch {
            delay(5000)
            flipOrFlop()
        }
    }

    data class FlipFlopModel(
        @StringRes val flipFlopString: Int
    )
}