package jp.making.felix.connpasssearcher.di.module

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class NetworkModule {
    @Provides
    fun providesOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                connectTimeout(120, TimeUnit.SECONDS)
                readTimeout(60, TimeUnit.SECONDS)
                writeTimeout(60, TimeUnit.SECONDS)
            }
            .addInterceptor(
                HttpLoggingInterceptor()
                .apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            .build()
    }

    @Provides
    @Named("connpass")
    internal fun provideRetrofit(
        oktHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .client(oktHttpClient)
        .baseUrl("https://connpass.com/")
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .build()

    @Provides
    internal fun provideApi(
        @Named("connpass") retrofit: Retrofit
    ): ConnpassService {
        return retrofit.create(ConnpassService::class.java)
    }
}