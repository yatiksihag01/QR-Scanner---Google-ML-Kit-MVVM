package com.yatik.qrscanner.di

import android.content.Context
import com.yatik.qrscanner.network.UrlPreviewApi
import com.yatik.qrscanner.utils.connectivity.ConnectivityHelper
import com.yatik.qrscanner.utils.connectivity.DefaultConnectivityHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(5, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl("https://localhost/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideUrlPreviewApi(
        retrofit: Retrofit
    ): UrlPreviewApi = retrofit.create(UrlPreviewApi::class.java)

    @Provides
    fun provideConnectivityHelper(
        @ApplicationContext appContext: Context
    ): ConnectivityHelper = DefaultConnectivityHelper(appContext)

}