
package com.pil.tp_04.mvvm.viewModel

import com.pil.tp_04.mvvm.contract.CounterContract
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.pil.tp_04.mvvm.model.CounterModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


class CounterViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: CounterContract.ViewModel

    @Before
    fun setup() {
        viewModel = CounterViewModel(CounterModel())
    }

    @Test
    fun `on increment button pressed with number test`() {
        viewModel.incValue(FIVE)
        assertEquals(FIVE, viewModel.getValue().value?.value)
        assertEquals(CounterViewModel.CounterState.INC, viewModel.getValue().value?.state)
    }

    @Test
    fun `on decrement button pressed test`() {
        viewModel.incValue(SEVEN)
        viewModel.decValue(SEVEN)
        assertEquals(ZERO, viewModel.getValue().value?.value)
        assertEquals(CounterViewModel.CounterState.DEC, viewModel.getValue().value?.state)
    }

    @Test
    fun `on reset button pressed test`() {
        viewModel.incValue(SEVEN)
        viewModel.incValue(FIVE)
        viewModel.resetValue()
        assertEquals(ZERO, viewModel.getValue().value?.value)
        assertEquals(CounterViewModel.CounterState.RES, viewModel.getValue().value?.state)
    }

    companion object {
        private const val ZERO = 0
        private const val FIVE = 5
        private const val SEVEN = 7
    }
}
