package com.pil.tp_04.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pil.tp_04.mvvm.contract.CounterContract

class CounterViewModel(private val model: CounterContract.Model) : ViewModel(), CounterContract.ViewModel {

    private val mutableLiveData: MutableLiveData<CounterData> = MutableLiveData()
    val data: LiveData<CounterData> = mutableLiveData


    override fun getValue(): LiveData<CounterData> {
        return mutableLiveData
    }

    override fun getInputValue() {
        mutableLiveData.postValue(CounterData(CounterState.INITIAL))
    }

    override fun incValue() {
        model.increment(getInputValue().toString().toInt())
        mutableLiveData.postValue(CounterData(CounterState.INC))
    }

    override fun decValue() {
        model.decrement(getValue().toString().toInt())
        mutableLiveData.postValue(CounterData(CounterState.DEC))
    }

    override fun resetValue() {
        model.reset()
        mutableLiveData.postValue(CounterData(CounterState.RES, ZERO_STRING.toInt()))
    }

    data class CounterData(
        val state: CounterState = CounterState.INITIAL,
        val value: Int = 0,
    )

    enum class CounterState {
        INITIAL,
        INC,
        DEC,
        RES,
    }

    companion object {
        private const val ZERO_STRING = "0"
    }
}
