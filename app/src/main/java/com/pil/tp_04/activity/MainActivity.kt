package com.pil.tp_04.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pil.tp_04.R
import com.pil.tp_04.mvp.model.MainModel
import com.pil.tp_04.mvp.presenter.MainPresenter
import com.pil.tp_04.mvp.view.MainView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainPresenter(MainModel(), MainView(this))
    }
}
