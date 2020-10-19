package nz.co.redice.cocktailcloud.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import nz.co.redice.cocktailcloud.BuildConfig
import nz.co.redice.cocktailcloud.repo.remotes.CocktailService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    private const val serviceURL = "https://www.thecocktaildb.com/api/json/"


    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        val level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE

        val logging =
            HttpLoggingInterceptor().setLevel(level)

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(serviceURL)
            .build()
    }


    @Provides
    @Singleton
    fun provideNewsService(retrofit: Retrofit): CocktailService {
        return retrofit.create(CocktailService::class.java)
    }

}