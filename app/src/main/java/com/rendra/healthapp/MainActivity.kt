package com.rendra.healthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.rendra.healthapp.databinding.ActivityMainBinding
import com.rendra.healthapp.entity.UserEntity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        supportActionBar?.hide()
    }

    private fun initViews() {
        with(binding) {
            var aktifitasFisik = 0.00

            cbMembaca.setOnClickListener {
                if (binding.cbMembaca.isChecked) {
                    aktifitasFisik += 10.0
                }
            }

            cbMenyetir.setOnClickListener {
                if (binding.cbMenyetir.isChecked) {
                    aktifitasFisik += 10.0
                }
            }

            cbBerjalan.setOnClickListener {
                if (binding.cbBerjalan.isChecked) {
                    aktifitasFisik += 20.0
                }
            }

            cbMenyapu.setOnClickListener {
                if (binding.cbMenyapu.isChecked) {
                    aktifitasFisik += 20.0
                }
            }

            cbJalanCepat.setOnClickListener {
                if (binding.cbJalanCepat.isChecked) {
                    aktifitasFisik += 30.0
                }
            }

            cbBersepeda.setOnClickListener {
                if (binding.cbBersepeda.isChecked) {
                    aktifitasFisik += 30.0
                }
            }

            cbAerobik.setOnClickListener {
                if (binding.cbAerobik.isChecked) {
                    aktifitasFisik += 40.0
                }
            }

            cbMendaki.setOnClickListener {
                if (binding.cbMendaki.isChecked) {
                    aktifitasFisik += 40.0
                }
            }

            cbJogging.setOnClickListener {
                if (binding.cbJogging.isChecked) {
                    aktifitasFisik += 40.0
                }
            }

            btnHitung.setOnClickListener {
                var isEmpty = false
                if (etBeratBadan.text.trim().contentEquals("")) {
                    isEmpty = true
                    etBeratBadan.error = getString(R.string.isi_berat)
                }
                if (etTinggiBadan.text.trim().contentEquals("")) {
                    isEmpty = true
                    etBeratBadan.error = getString(R.string.isi_tinggi)
                }
                if (!isEmpty) {
                    val berat = etBeratBadan.text.toString()
                    val tinggi = etTinggiBadan.text.toString()
                    val hitungKebutuhanKalori = Intent(this@MainActivity, HitungActivity::class.java).apply {
                        putExtra("EXTRA_USER", UserEntity(tinggi, berat, aktifitasFisik))
                    }
                    startActivity(hitungKebutuhanKalori)
                }
            }
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rb_pria ->
                    if (checked) {
                        // jenis kelamin wanita
                        // 30 kkal * BBI
                    }
                R.id.rb_wanita ->
                    if (checked) {
                        // jenis kelamin pria
                        // 25 kkal * BBI
                    }
            }
        }
    }
}