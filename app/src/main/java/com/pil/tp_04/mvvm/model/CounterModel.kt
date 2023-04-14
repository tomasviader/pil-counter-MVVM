package com.pil.tp_04.mvvm.model

import com.pil.tp_04.mvvm.contract.CounterContract

class CounterModel : CounterContract.Model {
    override var counter: Int = ZERO_INT

    override fun increment(inputValue: Int) {
        counter += inputValue
    }

    override fun decrement(inputValue: Int) {
        counter -= inputValue
    }

    override fun reset() {
        counter = ZERO_INT
    }

    companion object {
        private const val ZERO_INT = 0
    }
}
