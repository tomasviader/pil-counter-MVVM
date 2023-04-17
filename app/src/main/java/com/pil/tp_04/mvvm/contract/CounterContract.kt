package com.pil.tp_04.mvvm.contract // ktlint-disable package-name

import androidx.lifecycle.LiveData
import com.pil.tp_04.mvvm.viewModel.CounterViewModel

interface CounterContract {
    interface Model {
        var counter: Int
        fun increment(inputValue: Int)
        fun decrement(inputValue: Int)
        fun reset()
    }

    interface ViewModel {
        fun incValue(inputValue: Int)
        fun decValue(inputValue: Int)
        fun resetValue()
        fun getValue(): LiveData<CounterViewModel.CounterData>
    }
}
