package com.kya.newsapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kya.newsapplication.databinding.ItemArticleBinding
import com.kya.newsapplication.framework.data.Article

class NewsAdapter : ListAdapter<Article, NewsAdapter.ItemNewsViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemNewsViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemNewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemNewsViewHolder(private val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Article) {
            binding.data = data
            binding.imageImage.load(data.urlToImage)
            binding.textPublished.text = data.publishedAt

            itemView.setOnClickListener {
                // 웹뷰로 이동
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
            oldItem == newItem
    }
}