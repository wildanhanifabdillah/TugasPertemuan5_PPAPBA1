package com.example.tugaspertemuan5

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<TextInputEditText>(R.id.username)
        val etEmail = findViewById<TextInputEditText>(R.id.email)
        val etPhone = findViewById<TextInputEditText>(R.id.phone)
        val etPassword = findViewById<TextInputEditText>(R.id.password)
        val btnRegister = findViewById<Button>(R.id.registerButton)

        sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val email = etEmail.text.toString()
            val phone = etPhone.text.toString()
            val password = etPassword.text.toString()

            // Simpan data ke SharedPreferences
            val editor = sharedPreferences.edit()
            editor.putString("username", username)
            editor.putString("email", email)
            editor.putString("phone", phone)
            editor.putString("password", password)
            editor.apply()

            // Pindah ke LoginActivity
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}