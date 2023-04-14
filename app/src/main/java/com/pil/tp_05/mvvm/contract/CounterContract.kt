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

    interface View {
        fun onIncrementButtonPressed(onClick: () -> Unit)
        fun onDecrementButtonPressed(onClick: () -> Unit)
        fun onResetButtonPressed(onClick: () -> Unit)
        fun getInputValue(): String
        fun showCounter(counter: String)
        fun clear()
    }


    interface ViewModel {
        fun getValue(): LiveData<CounterViewModel.CounterData>
        fun resetValue()
        fun incValue()
        fun decValue()
    }
}
