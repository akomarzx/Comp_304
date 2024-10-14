package com.ronald.ombao.activity

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.ronald.ombao.R


class OmbaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ombao)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val materialToolbar : MaterialToolbar = findViewById(R.id.materialToolbar_home_menu)
        setSupportActionBar(materialToolbar)

        val radioGroup = findViewById<RadioGroup>(R.id.radio_group_selected);
        val nextButton = findViewById<MaterialButton>(R.id.button_next)

        nextButton.setOnClickListener {
            val selectedId: Int = radioGroup.checkedRadioButtonId
            val radioButton = findViewById<View>(selectedId) as RadioButton
            Toast.makeText(this, radioButton.text.toString(), Toast.LENGTH_SHORT).show()
        }

    }

}