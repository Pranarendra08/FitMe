package com.rendra.healthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.healthapp.databinding.ActivityOnBoardingFiveBinding
import com.rendra.healthapp.entity.UserEntity

class OnBoardingFiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingFiveBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_GENDER = "extra_gender"
        const val EXTRA_WEIGHT = "extra_weight"
        const val EXTRA_HEIGHT = "extra_height"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingFiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        supportActionBar?.hide()
    }

    private fun initViews() {
        with(binding) {
            val nama = intent.getStringExtra(EXTRA_NAME)
            val jenisKelamin = intent.getStringExtra(EXTRA_GENDER)
            val berat = intent.getStringExtra(EXTRA_WEIGHT)
            val tinggi = intent.getStringExtra(EXTRA_HEIGHT)
            var aktifitasFisik = 0.00


            cbMembaca2.setOnClickListener {
                if (binding.cbMembaca2.isChecked) {
                    aktifitasFisik += 10.0
                }
            }

            cbMenyetir2.setOnClickListener {
                if (binding.cbMenyetir2.isChecked) {
                    aktifitasFisik += 10.0
                }
            }

            cbBerjalan2.setOnClickListener {
                if (binding.cbBerjalan2.isChecked) {
                    aktifitasFisik += 20.0
                }
            }

            cbMenyapu2.setOnClickListener {
                if (binding.cbMenyapu2.isChecked) {
                    aktifitasFisik += 20.0
                }
            }

            cbJalanCepat2.setOnClickListener {
                if (binding.cbJalanCepat2.isChecked) {
                    aktifitasFisik += 30.0
                }
            }

            cbBersepeda2.setOnClickListener {
                if (binding.cbBersepeda2.isChecked) {
                    aktifitasFisik += 30.0
                }
            }

            cbAerobik2.setOnClickListener {
                if (binding.cbAerobik2.isChecked) {
                    aktifitasFisik += 40.0
                }
            }

            cbMendaki2.setOnClickListener {
                if (binding.cbMendaki2.isChecked) {
                    aktifitasFisik += 40.0
                }
            }

            cbJogging2.setOnClickListener {
                if (binding.cbJogging2.isChecked) {
                    aktifitasFisik += 40.0
                }
            }

            btnNextOnboarding2.setOnClickListener {
                val hitungKebutuhanKalori = Intent(this@OnBoardingFiveActivity, MainActivity::class.java).apply {
                    putExtra("EXTRA_USER", UserEntity(nama.toString(), jenisKelamin.toString(), tinggi.toString(), berat.toString(), aktifitasFisik))
                }
                startActivity(hitungKebutuhanKalori)
            }
        }
    }
}