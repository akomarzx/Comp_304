package com.example.excercise1.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.excercise1.R
import com.example.excercise1.fragment.AttractionListFragment

class AttractionListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_attraction_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()

        val attractionListFragment = AttractionListFragment()
        val houseListBundle = Bundle()
        val type = intent.getStringExtra("type")
        houseListBundle.putString("type", type)
        attractionListFragment.arguments = houseListBundle
        mFragmentTransaction.replace(R.id.maps_fragmentContainerView, attractionListFragment)
        mFragmentTransaction.commit()
    }
}