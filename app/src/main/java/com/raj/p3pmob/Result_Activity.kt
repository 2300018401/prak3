package com.raj.p3pmob

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvFullName = findViewById<TextView>(R.id.tvFullName)
        val tvUsername = findViewById<TextView>(R.id.tvUsername)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvGender = findViewById<TextView>(R.id.tvGender)

        // Ambil data dari Intent
        val fullName = intent.getStringExtra("fullName")
        val username = intent.getStringExtra("username")
        val age = intent.getStringExtra("age")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")

        // Tampilkan hasil
        tvFullName.text = fullName
        tvUsername.text = username
        tvAge.text = age
        tvEmail.text = email
        tvGender.text = gender
    }
}
