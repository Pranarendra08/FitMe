package com.rendra.healthapp.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserEntity(
    val tinggi: String,
    val berat: String,
    val aktivitasFisik: Double,
) : Parcelable