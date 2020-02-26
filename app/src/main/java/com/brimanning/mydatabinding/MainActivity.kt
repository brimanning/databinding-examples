package com.brimanning.mydatabinding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.brimanning.mydatabinding.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        with(binding) {
            viewModel = this@MainActivity.viewModel
            lifecycleOwner = this@MainActivity
        }
    }
}
