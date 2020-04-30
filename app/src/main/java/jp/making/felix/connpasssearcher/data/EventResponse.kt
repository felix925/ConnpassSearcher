package jp.making.felix.connpasssearcher.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventResponse(
    val id: String,
    val title: String,
    val body: String,
    @Json(name = "likes_count")
    val likeCount: Int,
    @Json(name = "created_at")
    val createdAt: String,
    val url: String
)