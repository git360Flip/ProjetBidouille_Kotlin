package com.projetbidouillekotlin.createPassword

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
import com.projetbidouillekotlin.typePassword.TypePasswordActivity

class CreatePasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val prefs: SharedPreferences = getSharedPreferences("PBK", MODE_PRIVATE)
        if (prefs.contains("password")) {
            val intent = Intent(this, TypePasswordActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_create_password)
            val passwordInput1: EditText = findViewById(R.id.createPasswordInput1)
            val passwordInput2: EditText = findViewById(R.id.createPasswordInput2)
            val saveButton: Button = findViewById(R.id.createPasswordSaveButton)
            saveButton.setOnClickListener {
                when {
                    passwordInput1.text.isEmpty() || passwordInput2.text.isEmpty() -> {
                        Toast.makeText(this, "Password inputs must not be empty", LENGTH_LONG).show()
                    }
                    passwordInput1.text.toString() == passwordInput2.text.toString() -> {
                        prefs.edit().putString("password", passwordInput1.text.toString()).apply()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else -> {
                        Toast.makeText(this, "Passwords don't match", LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}