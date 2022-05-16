package com.vimal.myapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.vimal.myapplication.R

// Here ":" symbol is indicate that LoginFragment
// is child class of Fragment Class
class FirstFragment : Fragment() {

    lateinit var text_first: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.first_fragment, container, false
        )


    }
    // Here "layout_login" is a name of layout file
    // created for LoginFragment
}
