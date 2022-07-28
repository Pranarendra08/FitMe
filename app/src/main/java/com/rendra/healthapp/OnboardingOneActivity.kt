package com.rendra.healthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.healthapp.databinding.ActivityOnboardingOneBinding

class OnboardingOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        initViews()
    }

    private fun initViews() {
        with(binding) {
            btnNextOnboarding1.setOnClickListener {
                startActivity(Intent(this@OnboardingOneActivity, OnboardingTwoActivity::class.java))
            }
        }
    }
}