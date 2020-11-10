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
        val firstName = intent.getStringExtra("FirstName")
        val lastName = intent.getStringExtra("LastName")
        val email = intent.getStringExtra("Email")
        val phone = intent.getStringExtra("Phone")
        val birthday = intent.getStringExtra("Birthday")
        val example = intent.getStringExtra("Example")

        // textview
        val resultTv = findViewById<TextView>(R.id.resultTv)
        // set text
        resultTv.text = "First Name: $firstName\nLast Name: $lastName\nEmail: $email\nBirthday: $birthday\nPhone: $phone\nExample: $example"
    }
}