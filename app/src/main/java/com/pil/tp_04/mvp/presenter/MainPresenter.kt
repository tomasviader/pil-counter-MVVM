package com.pil.tp_04.mvp.presenter

import com.pil.tp_04.mvp.contract.MainContract

class MainPresenter(
    private val model: MainContract.Model,
    private val view: MainContract.View
) : MainContract.Presenter {

    init {
        view.onIncrementButtonPressed { onIncrementButtonPressed() }
        view.onDecrementButtonPressed { onDecrementButtonPressed() }
        view.onResetButtonPressed { onResetButtonPressed() }

        view.showCounter(model.counter.toString())
    }

    override fun onIncrementButtonPressed() {
        model.increment(getInputInt())
        view.showCounter(model.counter.toString())
    }

    override fun onDecrementButtonPressed() {
        model.decrement(getInputInt())
        view.showCounter(model.counter.toString())
    }

    private fun getInputInt(): Int = view.getInputValue().ifEmpty { ZERO_STRING }.toInt()

    override fun onResetButtonPressed() {
        model.reset()
        view.showCounter(model.counter.toString())
        view.clear()
    }

    companion object {
        private const val ZERO_STRING = "0"
    }
}
