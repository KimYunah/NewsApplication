package com.kya.newsapplication.framework.di

import com.kya.newsapplication.framework.network.NewsApiService
import com.kya.newsapplication.framework.network.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideNewsApiService(): NewsApiService {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }

    @Provides
    fun provideNewsRepository(apiService: NewsApiService): NewsRepository {
        return NewsRepository(apiService)
    }
}