package com.example.excercise1.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.excercise1.R
import com.example.excercise1.fragment.MapsFragment

class MapsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_maps)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()

        val mapsFragment = MapsFragment()
        val mapsBundle = Bundle()
        val latitude = intent.getDoubleExtra("latitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude", 0.0)
        val name = intent.getStringExtra("name")
        Toast.makeText(this, "${latitude} ${longitude}", Toast.LENGTH_SHORT).show()
        mapsBundle.putDouble("latitude", latitude)
        mapsBundle.putDouble("longitude", longitude)
        mapsBundle.putString("name", name)
        mapsFragment.arguments = mapsBundle
        mFragmentTransaction.replace(R.id.maps_fragmentContainerView, mapsFragment)
        mFragmentTransaction.commit()
    }
}