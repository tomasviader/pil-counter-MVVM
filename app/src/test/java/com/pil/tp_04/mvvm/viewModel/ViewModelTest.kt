package com.pil.tp_04.mvvm.viewModel

class ViewModelTest {

   /* private var view: MainContract.View = mockk(relaxed = true)

    private lateinit var presenter: MainContract.Presenter

    @Before
    fun setup() {
        presenter = ViewModel(MainModel(), view)

        verify { view.onIncrementButtonPressed(any()) }
        verify { view.onDecrementButtonPressed(any()) }
        verify { view.onResetButtonPressed(any()) }
        verify { view.showCounter(ZERO_STRING) }
    }

    @Test
    fun `on increment button pressed with number test`() {
        every { view.getInputValue() } returns FIVE_STRING

        presenter.onIncrementButtonPressed()

        verify { view.showCounter(FIVE_STRING) }
    }

    @Test
    fun `on increment button pressed without number test`() {
        every { view.getInputValue() } returns EMPTY_STRING

        presenter.onIncrementButtonPressed()

        verify { view.showCounter(ZERO_STRING) }
    }

    @Test
    fun `on decrement button pressed test`() {
        every { view.getInputValue() } returns SEVEN_STRING

        presenter.onDecrementButtonPressed()
        
        verify { view.showCounter(MINUS_SEVEN_STRING) }
    }

    @Test
    fun `on reset button pressed test`() {
        every { view.getInputValue() } returns SEVEN_STRING

        presenter.onIncrementButtonPressed()

        verify { view.showCounter(SEVEN_STRING) }

        presenter.onResetButtonPressed()

        verify { view.showCounter(ZERO_STRING) }
        verify { view.clear() }
    }

    companion object {
        private const val ZERO_STRING = "0"
        private const val FIVE_STRING = "5"
        private const val SEVEN_STRING = "7"
        private const val MINUS_SEVEN_STRING = "-7"
        private const val EMPTY_STRING = ""
    }*/
}
