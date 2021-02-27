package com.projetbidouillekotlin.typePassword

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import com.projetbidouillekotlin.MainActivity
import com.projetbidouillekotlin.R
import com.projetbidouillekotlin.createPassword.CreatePasswordActivity

class TypePasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val prefs: SharedPreferences = getSharedPreferences("PBK", MODE_PRIVATE)
        if (!prefs.contains("password")) {
            val intent = Intent(this, CreatePasswordActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_type_password)
            val passwordInput: EditText = findViewById(R.id.typePasswordInput)
            val confirmButton: Button = findViewById(R.id.typePasswordConfirmButton)
            confirmButton.setOnClickListener {
                when {
                    passwordInput.text.isEmpty() -> {
                        Toast.makeText(this, "Please enter a password", LENGTH_LONG).show()
                    }
                    passwordInput.text.toString() == prefs.getString("password", "") -> {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }
}