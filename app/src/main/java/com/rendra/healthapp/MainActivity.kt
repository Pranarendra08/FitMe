package com.rendra.healthapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rendra.healthapp.databinding.ActivityMainBinding
import com.rendra.healthapp.entity.UserEntity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val User = intent.getParcelableExtra<UserEntity>("EXTRA_USER")
        if (User != null) {
            initViews(User)
            supportActionBar?.hide()
        }

    }

    private fun initViews(user: UserEntity) {
        with(binding) {
            val nama = user.nama
            val jenisKelamin = user.jenisKelamin
            val berat = user.berat.toDouble()
            var tinggi = user.tinggi.toDouble()
            val aktivitas = user.aktivitasFisik / 100.0

            tinggi /= 100.0
            var bmi = berat / (tinggi*tinggi)

            tinggi = tinggi * 100.0
            var bbi  = (tinggi - 100) - (0.1 * ( tinggi - 100))

            var kkb = 0.0
            if (jenisKelamin == "Pria") {
                kkb = 30 * bbi
            }
            if (jenisKelamin == "Wanita") {
                kkb = 25 * bbi
            }

            var kkt = kkb + (aktivitas * kkb)

            var protein = 15.0 / 100.0
            var kebutuhanProtein = (protein * kkt) / 4

            var lemak = 20.0 / 100.0
            var kebutuhanLemak = (lemak * kkt) / 9

            var karbo = 65.0/100.0
            var kebutuhanKarbo = (karbo * kkt) / 4

            tvNama.text = "Hai, $nama"
            tvBeratBadanSekarang.text = "%.1f Kg".format(berat)
            tvBbi.text = "%.1f Kg".format(bbi)
            tvKebutuhanKalori.text = "%.1f calories".format(kkt)
            //tvBmi.text = bmi.toString()
            tvProtein.text = "%.1f".format(kebutuhanProtein)
            tvLemak.text = "%.1f".format(kebutuhanLemak)
            tvKarbohidrat.text = "%.1f".format(kebutuhanKarbo)
        }
    }
}