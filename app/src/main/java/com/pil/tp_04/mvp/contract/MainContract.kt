package com.pil.tp_04.mvp.contract

interface MainContract {
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

    interface Presenter {
        fun onIncrementButtonPressed()
        fun onDecrementButtonPressed()
        fun onResetButtonPressed()
    }
}
