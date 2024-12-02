package com.example.dotaheroes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.dotaheroes.databinding.ActivityProfileBinding


class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showPhotoProfile()
    }

    private fun showPhotoProfile() {
        Glide.with(this).load(R.drawable.img_profile).circleCrop().into(binding.ivPhotoProfile)
    }
}