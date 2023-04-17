package com.pil.tp_04.mvvm.viewModel // ktlint-disable package-name

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pil.tp_04.mvvm.contract.CounterContract

class CounterViewModel(private val model: CounterContract.Model) : ViewModel(), CounterContract.ViewModel {

    private val mutableData: MutableLiveData<CounterData> = MutableLiveData()
    val data: LiveData<CounterData> = mutableData

    override fun getValue(): LiveData<CounterData> {
        return mutableData
    }

    override fun incValue(inputValue: Int) {
        model.increment(inputValue)
        mutableData.postValue(CounterData(CounterState.INC, model.counter))
    }

    override fun decValue(inputValue: Int) {
        model.decrement(inputValue)
        mutableData.postValue(CounterData(CounterState.DEC, model.counter))
    }

    override fun resetValue() {
        model.reset()
        mutableData.postValue(CounterData(CounterState.RES, ZERO_STRING.toInt()))
    }

    data class CounterData(
        val state: CounterState,
        val value: Int = ZERO_INT,
    )

    enum class CounterState {
        INC,
        DEC,
        RES,
    }

    companion object {
        private const val ZERO_STRING = "0"
        private const val ZERO_INT = 0
    }
}
