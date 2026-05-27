package com.example.myapplication

import android.os.Bundle
import android.view.Display
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.TXTDISPLAY)

        // Variables
        var row = 1
        val maxRows = 7
        var asciiArt = ""

        // While loop to build the pattern
        while (row <= maxRows) {
            var col = 1
            var line = ""

            while (col <= row) {
                line += "* "
                col++
            }

            asciiArt += line.trim() + "\n"
            row++
        }

        textView.text = asciiArt



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}