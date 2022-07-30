package com.rendra.healthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.healthapp.databinding.ActivityOnBoardingFourBinding
import com.rendra.healthapp.entity.UserEntity

class OnBoardingFourActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingFourBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_GENDER = "extra_gender"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        supportActionBar?.hide()
    }

    private fun initViews() {
        with(binding) {
            val nama = intent.getStringExtra(EXTRA_NAME)
            val jenisKelamin = intent.getStringExtra(EXTRA_GENDER)

            btnNextOnboarding.setOnClickListener {
                var isEmpty = false
                if (etBerat.text.trim().contentEquals("")) {
                    isEmpty = true
                    etBerat.error = getString(R.string.isi_berat)
                }
                if (etTinggi.text.trim().contentEquals("")) {
                    isEmpty = true
                    etBerat.error = getString(R.string.isi_tinggi)
                }
                if (!isEmpty) {
                    val berat = etBerat.text.toString()
                    val tinggi = etTinggi.text.toString()
                    val nextActivity = Intent(this@OnBoardingFourActivity, OnBoardingFiveActivity::class.java)
                    nextActivity.putExtra(OnBoardingFiveActivity.EXTRA_NAME, nama)
                    nextActivity.putExtra(OnBoardingFiveActivity.EXTRA_GENDER, jenisKelamin)
                    nextActivity.putExtra(OnBoardingFiveActivity.EXTRA_WEIGHT, berat)
                    nextActivity.putExtra(OnBoardingFiveActivity.EXTRA_HEIGHT, tinggi)
                    startActivity(nextActivity)
                }
            }
        }
    }
}