package com.gusoft.planes_rcview_example_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gusoft.planes_rcview_example_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}