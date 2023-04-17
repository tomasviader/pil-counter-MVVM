package com.pil.tp_04.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pil.tp_04.databinding.ActivityMainBinding
import com.pil.tp_04.mvvm.model.CounterModel
import com.pil.tp_04.mvvm.viewModel.CounterViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var viewModel: CounterViewModel = CounterViewModel(CounterModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.increment.setOnClickListener { viewModel.incValue(binding.inputCount.text.toString().toInt()) }
        binding.decrement.setOnClickListener { viewModel.decValue(binding.inputCount.text.toString().toInt())  }
        binding.reset.setOnClickListener { viewModel.resetValue() }

        viewModel.data.observe({ lifecycle }, ::updateUI)
    }

    private fun updateUI(it: CounterViewModel.CounterData) {
        when (it.state) {
            CounterViewModel.CounterState.INC -> {
                binding.counter.text = it.value.toString()
            }
            CounterViewModel.CounterState.DEC -> {
                binding.counter.text = it.value.toString()
            }
            CounterViewModel.CounterState.RES -> {
                binding.counter.text = it.value.toString()
                binding.inputCount.text.clear()
            }

        }
    }
}
