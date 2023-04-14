package com.pil.tp_05.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pil.tp_04.databinding.ActivityMainBinding
import com.pil.tp_05.mvvm.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    private lateinit var viewModel : ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CounterViewModel::class.java]

        /*binding.increment.setOnClickListener { (viewModel as CounterViewModel).incValue() }
        binding.decrement.setOnClickListener { (viewModel as CounterViewModel).decValue() }
        binding.reset.setOnClickListener { (viewModel as CounterViewModel).resetValue() }
*/
        (viewModel as CounterViewModel).getValue().observe(this) { updateUI(it) }
    }

    private fun updateUI(it: CounterViewModel.CounterData) {
        when (it.state) {
            CounterViewModel.CounterState.INITIAL -> {
                binding.countLabel.text = count
                binding.reset.setOnClickListener { (viewModel as CounterViewModel).resetValue() }
            }
            CounterViewModel.CounterState.INC -> {
                binding.increment.setOnClickListener { (viewModel as CounterViewModel).incValue() }
            }
            CounterViewModel.CounterState.DEC -> {
                binding.decrement.setOnClickListener { (viewModel as CounterViewModel).decValue() }
            }
        }
    }


}
