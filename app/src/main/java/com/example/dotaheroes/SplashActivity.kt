package com.example.dotaheroes

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            isLog()
        }, 3000)
    }

    private fun isLog() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}