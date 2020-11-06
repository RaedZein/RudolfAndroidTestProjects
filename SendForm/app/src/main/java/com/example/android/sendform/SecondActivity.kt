package com.example.android.sendform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // get data from intent
        var intent = intent
        val name = intent.getStringExtra("Name")
        val email = intent.getStringExtra("Email")
        val phone = intent.getStringExtra("Phone")
        val birthday = intent.getStringExtra("Birthday")

        // textview
        val resultTv = findViewById<TextView>(R.id.resultTv)
        // set text
        resultTv.text = "Name: $name\nEmail: $email\nBirthday: $birthday\nPhone: $phone"

    }
}