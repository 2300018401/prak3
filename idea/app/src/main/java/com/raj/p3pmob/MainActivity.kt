package com.raj.p3pmob

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFullName = findViewById<EditText>(R.id.isinama)
        val etUsername = findViewById<EditText>(R.id.isiusername)
        val etAge = findViewById<EditText>(R.id.isiumur)
        val etEmail = findViewById<EditText>(R.id.isiemail)
        val rbMale = findViewById<RadioButton>(R.id.rbMale)
        val rbFemale = findViewById<RadioButton>(R.id.rbFemale)
        val etPassword = findViewById<EditText>(R.id.isipassword)
        val etConfirm = findViewById<EditText>(R.id.isiconfirm)
        val btnSubmit = findViewById<Button>(R.id.button)

        btnSubmit.setOnClickListener {
            val fullName = etFullName.text.toString()
            val username = etUsername.text.toString()
            val age = etAge.text.toString()
            val email = etEmail.text.toString()
            val gender = if (rbMale.isChecked) "Laki-laki" else "Perempuan"
            val password = etPassword.text.toString()
            val confirm = etConfirm.text.toString()

            // Validasi form kosong
            if (fullName.isEmpty() || username.isEmpty() || age.isEmpty() || email.isEmpty() ||
                password.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validasi password tidak sama
            if (password != confirm) {
                AlertDialog.Builder(this)
                    .setTitle("Password Tidak Sama")
                    .setMessage("Password dan Konfirmasi Password harus sama!")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()
                return@setOnClickListener
            }

            // Kirim data ke ResultActivity
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("fullName", fullName)
            intent.putExtra("username", username)
            intent.putExtra("age", age)
            intent.putExtra("email", email)
            intent.putExtra("gender", gender)
            startActivity(intent)
        }
    }
}
