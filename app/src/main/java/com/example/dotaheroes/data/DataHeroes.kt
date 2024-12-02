package com.example.dotaheroes.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataHeroes(
    val name: String,
    val subtitle: String,
    val desc: String?,
    val classes: String?,
    val role: String?,
    val attackType: String?,
    val photo: Int,
) : Parcelable
