package com.kya.newsapplication.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.kya.newsapplication.R
import com.kya.newsapplication.databinding.ActivityMainBinding
import com.kya.newsapplication.ui.adapter.NewsAdapter
import com.kya.newsapplication.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = NewsAdapter()
        val spanCount = if (resources.configuration.screenWidthDp >= 600) 3 else 1
        binding.recyclerView.layoutManager = GridLayoutManager(this, spanCount)
        binding.recyclerView.adapter = adapter

        viewModel.newsLiveData.observe(this) { articles ->
            adapter.submitList(articles)
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.fetchNews()
    }
}