package com.example.layout_learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.layout_learning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val view = binding.root

        setContentView(view)
    }

    fun hi(view: View) {
        val name = binding.txtName.text
        Toast.makeText(this, "Hi !$name", Toast.LENGTH_LONG).show()
    }
}