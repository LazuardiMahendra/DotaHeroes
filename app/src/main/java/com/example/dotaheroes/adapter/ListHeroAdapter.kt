package com.example.dotaheroes.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dotaheroes.DetailActivity
import com.example.dotaheroes.data.DataHeroes
import com.example.dotaheroes.databinding.ItemHeroBinding

class ListHeroAdapter(
    private val model: ArrayList<DataHeroes>
) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    inner class ListViewHolder(val binding: ItemHeroBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        with(holder) {
            with(model[position]) {
                binding.ivItemPhoto.setImageResource(photo)
                binding.tvItemName.text = name
                binding.tvItemDesc.text = subtitle
                holder.itemView.setOnClickListener {
                    val intent = Intent(holder.itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_NAME, name)
                    intent.putExtra(DetailActivity.EXTRA_SUBTITLE, subtitle)
                    intent.putExtra(DetailActivity.EXTRA_DESC, desc)
                    intent.putExtra(DetailActivity.EXTRA_CLASSES, classes)
                    intent.putExtra(DetailActivity.EXTRA_ROLE, role)
                    intent.putExtra(DetailActivity.EXTRA_ATTACK_TYPE, attackType)
                    intent.putExtra(DetailActivity.EXTRA_PHOTO, photo)
                    holder.itemView.context.startActivity(intent)
                }

            }
        }
    }

    override fun getItemCount(): Int = model.size

}
