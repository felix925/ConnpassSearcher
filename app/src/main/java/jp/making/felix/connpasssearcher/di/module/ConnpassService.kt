package jp.making.felix.connpasssearcher.di.module

import jp.making.felix.connpasssearcher.data.EventResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ConnpassService {
        @GET("api/v1/event/")
        suspend fun getTaggedArticles(
            @Query("keyword") keyword: String = "android",
            @Query("keyword_or") keyword_or: String = "android",
            @Query("order") order: Int = 3,
            @Query("count") count: Int = 20
        ): List<EventResponse>
}