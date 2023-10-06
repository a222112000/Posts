package space.stanton.technicaltest.brightones.features.post.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import space.stanton.technicaltest.brightones.features.post.data.repository.ImplPostsRepository
import space.stanton.technicaltest.brightones.features.post.data.repository.PostService
import space.stanton.technicaltest.brightones.features.post.utils.Constants.Companion.BASE_URL
import space.stanton.technicaltest.brightones.features.post.domain.PostsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideApiRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(
                GsonBuilder().create()
            ))
            .build()
    }

    @Singleton
    @Provides
    fun providePostService():PostService = provideApiRetrofit().create(PostService::class.java)

    @Provides
    @Singleton
    fun providePostRepository(api: PostService):PostsRepository{
        return ImplPostsRepository(api)
    }
}