package com.example.dotaheroes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dotaheroes.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_SUBTITLE = "extra_subtitle"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_CLASSES = "extra_classes"
        const val EXTRA_ROLE = "extra_role"
        const val EXTRA_ATTACK_TYPE = " extra_attack_type"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val subtitle = intent.getStringExtra(EXTRA_SUBTITLE)
        val desc = intent.getStringExtra(EXTRA_DESC)
        val classes = intent.getStringExtra(EXTRA_CLASSES)
        val role = intent.getStringExtra(EXTRA_ROLE)
        val attackType = intent.getStringExtra(EXTRA_ATTACK_TYPE)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        if (attackType != "Meele") {
            binding.ivAttackType.setImageResource(R.drawable.ranged)
        } else {
            binding.ivAttackType.setImageResource(R.drawable.melee)
        }

        binding.tvTitle.text = name
        binding.tvSubtitle.text = subtitle
        binding.tvDesc.text = desc
        binding.tvAttackType.text = attackType
        binding.tvRoles.text = role
        binding.ivPhoto.setImageResource(photo)

    }
}