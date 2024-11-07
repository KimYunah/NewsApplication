package com.kya.newsapplication.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kya.newsapplication.framework.data.Article
import com.kya.newsapplication.framework.network.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NewsRepository,
    application: Application
) : AndroidViewModel(application) {

    private val _newsLiveData = MutableLiveData<List<Article>?>()
    val newsLiveData: MutableLiveData<List<Article>?> = _newsLiveData

    fun fetchNews() {
        viewModelScope.launch {
            try {
                val articles = repository.getTopHeadlines()
                _newsLiveData.value = articles
            } catch (e: Exception) {
                // 에러 처리 추가
                e.printStackTrace()
            }
        }
    }
}