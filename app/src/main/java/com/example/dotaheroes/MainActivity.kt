package com.example.dotaheroes

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dotaheroes.adapter.ListHeroAdapter
import com.example.dotaheroes.data.DataHeroes
import com.example.dotaheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvHeroes: RecyclerView

    private val listHero = ArrayList<DataHeroes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvHeroes = binding.rvHeroes
        rvHeroes.setHasFixedSize(true)

        listHero.addAll(getListHeroes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvHeroes.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_grid -> {
                rvHeroes.layoutManager = GridLayoutManager(this, 2)
            }

            R.id.about_page -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun getListHeroes(): ArrayList<DataHeroes> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataSubtitle = resources.getStringArray(R.array.data_subtitle)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataClasses = resources.getStringArray(R.array.data_classes)
        val dataAttackType = resources.getStringArray(R.array.data_attack_type)
        val dataRole = resources.getStringArray(R.array.data_role)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<DataHeroes>()
        for (i in dataName.indices) {
            val hero = DataHeroes(
                dataName[i],
                dataSubtitle[i],
                dataDesc[i],
                "test",
                dataRole[i],
                dataAttackType[i],
                dataPhoto.getResourceId(i, -1)
            )
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val lisHeroAdapter = ListHeroAdapter(listHero)
        rvHeroes.adapter = lisHeroAdapter
    }
}
