package com.kya.newsapplication.framework.network

import com.kya.newsapplication.framework.data.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiService: NewsApiService
) {

    suspend fun getTopHeadlines(): List<Article>? {
        return apiService.getTopHeadlines().articles // 서버 데이터 그대로 반환
    }
}