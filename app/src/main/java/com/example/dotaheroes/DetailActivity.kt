package com.example.dotaheroes

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.dotaheroes.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

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

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Hero "

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

        when (classes) {
            "Universal" -> {
                binding.ivClasses.setImageResource(R.drawable.ic_universal)
            }

            "Strength" -> {
                binding.ivClasses.setImageResource(R.drawable.ic_strength)
            }

            "Agility" -> {
                binding.ivClasses.setImageResource(R.drawable.ic_agility)
            }

            "Intelligence" -> {
                binding.ivClasses.setImageResource(R.drawable.ic_intelligence)
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Hero $name"

        binding.tvTitle.text = name
        binding.tvSubtitle.text = subtitle
        binding.tvDesc.text = desc
        binding.tvAttackType.text = attackType
        binding.tvClasses.text = classes
        binding.tvRoles.text = role
        binding.ivPhoto.setImageResource(photo)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                val url = "https://www.dota2.com/hero/${
                    intent.getStringExtra(EXTRA_NAME).toString().lowercase()
                }"
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, url)
                }
                startActivity(Intent.createChooser(intent, "Share via"))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}