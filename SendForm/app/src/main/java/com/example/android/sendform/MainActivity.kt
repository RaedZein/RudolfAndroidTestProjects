package com.example.android.sendform

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.core.view.get
import java.util.*

class MainActivity : AppCompatActivity() {
    private var selectedYear = 0
    private var selectedMonth = 0
    private var selectedDay = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNameEt = findViewById<EditText>(R.id.firstNameEt)
        val lastNameEt = findViewById<EditText>(R.id.lastNameEt)
        val emailEt = findViewById<EditText>(R.id.emailEt)
        val phoneEt = findViewById<EditText>(R.id.phoneEt)

        val mPickTimeBtn = findViewById<Button>(R.id.pickDateBtn)

        val saveBtn = findViewById<Button>(R.id.saveBtn)

        mPickTimeBtn.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
                this.selectedYear = selectedYear
                this.selectedMonth = selectedMonth
                this.selectedDay = selectedDay

            }, year, month, day)
            dpd.show()
        }

        // handle button click
        saveBtn.setOnClickListener {

            // Get the the current year, month and day of month picked from calendar
            val birthday = "$selectedDay/${selectedMonth + 1}/$selectedYear"

            // get text from edittexts
            val firstName = firstNameEt.text.toString()
            val lastName = lastNameEt.text.toString()
            val email = emailEt.text.toString()
            val phone = phoneEt.text.toString()


            // intent to start activity
            val intent = Intent(this@MainActivity, SecondActivity::class.java )
            intent.putExtra("FirstName", firstName)
            intent.putExtra("LastName", lastName)
            intent.putExtra("Email", email)
            intent.putExtra("Phone", phone)
            intent.putExtra("Birthday", birthday)

            startActivity(intent)
        }
    }
}

/**
 * 1 create second activity
 * 2 create inputs and button
 * 3 create your functions
 * 4 create textviews in second activity and display data
 * 5 create button to open date picker
 */