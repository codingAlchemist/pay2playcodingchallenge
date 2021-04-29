package care.ai.play2paycodingchallenge.service

import care.ai.play2paycodingchallenge.models.EbayItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiService {
    companion object{
        private val baseUrl = "https://play2pay-assets.s3.amazonaws.com"
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val service = retrofit.create(ApiCalls::class.java)

        fun getEbayItems(onSuccess:(List<EbayItem>) -> Unit, onFailure:(Throwable) -> Unit){
            val request = service.getEbayItems()
            retrofit.callFactory()
            request.enqueue(callback { throwable, response ->
                response?.body()?.let {
                    onSuccess(it)
                }?:throwable?.let {
                    onFailure(it)
                }?: kotlin.run {
                    onFailure(getDefaultError(response?.message()))
                }
            })
        }

        private fun <T> callback(fn: (Throwable?, Response<T>?) -> Unit): Callback<T> {
            return object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) = fn(null, response)
                override fun onFailure(call: Call<T>, t: Throwable) = fn(t, null)
            }
        }

        private fun getDefaultError(message: String?): Throwable {
            return Throwable(message = message ?: "An error has occurred")
        }
    }

}