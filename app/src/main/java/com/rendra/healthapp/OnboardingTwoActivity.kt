package com.rendra.healthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.healthapp.databinding.ActivityOnboardingTwoBinding

class OnboardingTwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        supportActionBar?.hide()
    }

    private fun initViews() {
        with(binding) {
            btnNextOnboarding1.setOnClickListener {
                var isEmpty = false
                if (etNama.text.trim().contentEquals("")) {
                    isEmpty = true
                    etNama.error = getString(R.string.isi_nama)
                }
                if (!isEmpty) {
                    val nama = etNama.text.toString()
                    val nextActivity = Intent(this@OnboardingTwoActivity, OnBoardingThreeActivity::class.java)
                    nextActivity.putExtra(OnBoardingThreeActivity.EXTRA_NAME, nama)
                    startActivity(nextActivity)
                }
            }
        }
    }
}