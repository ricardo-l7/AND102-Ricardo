package com.example.simplecouter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.addButton)
        val countText = findViewById<TextView>(R.id.count)
        button.setOnClickListener{
            count++
            countText.text = count.toString()
        }
    }
}
