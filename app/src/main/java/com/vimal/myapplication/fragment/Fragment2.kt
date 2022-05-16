package com.vimal.myapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vimal.myapplication.R
import com.vimal.myapplication.databinding.Fragment2Binding

class Fragment2 : Fragment(R.layout.fragment_2) {

    private var inputText: String? = ""

    private var fragment2Binding: Fragment2Binding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = Fragment2Binding.inflate(inflater, container, false)
        fragment2Binding = binding
        inputText = arguments?.getString("input_txt")

        binding.outputTextview.text = inputText

        return binding.root
    }

    override fun onDestroyView() {
        fragment2Binding = null
        super.onDestroyView()
    }

}