package com.kya.newsapplication.framework.network

import com.kya.newsapplication.framework.data.NewsResponse
import retrofit2.http.GET

interface NewsApiService {
    @GET("v2/top-headlines?country=us&apiKey=269bc85d14c24be78f8a5a5fde4058ad")  // "your_endpoint"을 실제 URL 경로로 바꾸세요.
    suspend fun getTopHeadlines(): NewsResponse // ApiResponse는 실제 API 응답 데이터 모델
}