package com.rendra.healthapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.healthapp.databinding.ActivityHitungBinding
import com.rendra.healthapp.entity.UserEntity

class HitungActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHitungBinding

//    companion object {
//        const val EXTRA_HEIGHT_WEIGHT = "extra_height_weight"
//        const val EXTRA_ACTIVIES = "extra_activities"
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHitungBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val User = intent.getParcelableExtra<UserEntity>("EXTRA_USER")
        if (User != null) {
            initViews(User)
        }
    }

    private fun initViews(user: UserEntity) {
        with(binding) {
            val berat = user.berat
            val tinggi = user.tinggi
            val aktivitas = user.aktivitasFisik.toString()

            tvBerat.text = berat
            tvTinggi.text = tinggi
            tvAktivitas.text = aktivitas
        }
    }
}