package com.vimal.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.vimal.myapplication.R
import com.vimal.myapplication.fragment.Fragment1
import com.vimal.myapplication.fragment.Fragment2
import com.vimal.myapplication.interfaces.Communicator

class FragmentPassDataActivity : AppCompatActivity() ,Communicator{

//    private lateinit var binding: ActivityFragmentPassDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_pass_data)

        val fragment1 = Fragment1()
        supportFragmentManager.beginTransaction().replace(R.id.content_id, fragment1).commit()
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityFragmentPassDataBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//        // Replace Main Activity content with the Fragment1 content
//
//
//    }

    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("input_txt", editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val frag2 = Fragment2()
        frag2.arguments = bundle

        transaction.replace(R.id.content_id, frag2)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}