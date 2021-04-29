package care.ai.play2paycodingchallenge.service

import care.ai.play2paycodingchallenge.models.EbayItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiCalls {

    @GET("/engineering/books.json")
    fun getEbayItems(): Call<List<EbayItem>>
}