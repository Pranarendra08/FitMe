package com.rendra.healthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.healthapp.databinding.ActivityOnBoardingThreeBinding

class OnBoardingThreeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingThreeBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        supportActionBar?.hide()
    }

    private fun initViews() {
        with(binding) {
            val nama = intent.getStringExtra(EXTRA_NAME)

            btnPria.setOnClickListener {
                val nextActivity = Intent(this@OnBoardingThreeActivity, OnBoardingFourActivity::class.java)
                nextActivity.putExtra(OnBoardingFourActivity.EXTRA_NAME, nama)
                nextActivity.putExtra(OnBoardingFourActivity.EXTRA_GENDER, "Pria")
                startActivity(nextActivity)
            }

            btnWanita.setOnClickListener {
                val nextActivity = Intent(this@OnBoardingThreeActivity, OnBoardingFourActivity::class.java)
                nextActivity.putExtra(OnBoardingFourActivity.EXTRA_NAME, nama)
                nextActivity.putExtra(OnBoardingFourActivity.EXTRA_GENDER, "Wanita")
                startActivity(nextActivity)
            }
        }
    }
}