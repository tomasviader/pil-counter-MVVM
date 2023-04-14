package com.pil.tp_05.mvvm.contract

import androidx.lifecycle.LiveData
import com.pil.tp_05.mvvm.viewmodel.CounterViewModel

interface CounterContract {
    interface Model {
        var counter: Int
        fun increment(inputValue: Int)
        fun decrement(inputValue: Int)
        fun reset()
    }

    interface ViewModel {
        fun getValue(): LiveData<CounterViewModel.CounterData>

        fun getInputValue()
        fun resetValue()
        fun incValue()
        fun decValue()
    }
}
