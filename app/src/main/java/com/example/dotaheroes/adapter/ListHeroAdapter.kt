package com.example.dotaheroes.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dotaheroes.DetailActivity
import com.example.dotaheroes.R
import com.example.dotaheroes.data.DataHeroes

class ListHeroAdapter(
    private val model: ArrayList<DataHeroes>
) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, subtitle, desc, classes, role, attackType, photo) = model[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvSubtitle.text = subtitle
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

    override fun getItemCount(): Int = model.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvSubtitle: TextView = itemView.findViewById(R.id.tv_item_desc)
    }

    interface OnClickCallback {
        fun onItemClicked(data: DataHeroes)
    }
}
