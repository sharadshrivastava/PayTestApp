package com.test.myapplication.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.test.myapplication.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    val vm:MainViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm.weatherByCity("Sydney").observe(viewLifecycleOwner, Observer {
            val temp = it.main?.temp
            val humidity = it.main?.humidity

            tvCity.text = "Sydney"
            tvTemp.text = temp.toString()
            tvHumidity.text = humidity.toString()

        })
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}