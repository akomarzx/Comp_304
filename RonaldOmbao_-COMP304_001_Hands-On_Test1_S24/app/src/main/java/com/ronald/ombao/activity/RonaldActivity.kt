package com.ronald.ombao.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.ronald.ombao.databinding.ActivityRonaldBinding

class RonaldActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityRonaldBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRonaldBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonMainEnter.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, OmbaoActivity::class.java)
        startActivity(intent)
    }

}