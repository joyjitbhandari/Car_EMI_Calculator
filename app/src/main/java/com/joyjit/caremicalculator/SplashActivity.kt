package com.joyjit.caremicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.joyjit.caremicalculator.R.layout.activity_splash

class SplashActivity : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_splash)
        supportActionBar?.hide()
        handler = Handler()
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },300L)
    }
}


