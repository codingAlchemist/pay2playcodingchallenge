package care.ai.play2paycodingchallenge.models

import com.google.gson.annotations.SerializedName

data class EbayItem(@SerializedName("title") val title: String,
                    @SerializedName("author") val author: String? = null,
                    @SerializedName("imageURL") val imageURL: String)