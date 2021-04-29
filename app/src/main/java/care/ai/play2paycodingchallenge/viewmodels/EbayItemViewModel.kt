package care.ai.play2paycodingchallenge.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import care.ai.play2paycodingchallenge.models.EbayItem

class EbayItemViewModel:ViewModel() {

    val items = MutableLiveData<List<EbayItem>>()

    fun setItems(items: List<EbayItem>){
        this.items.postValue(items)
    }
}