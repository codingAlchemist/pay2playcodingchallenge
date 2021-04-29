package care.ai.play2paycodingchallenge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import care.ai.play2paycodingchallenge.R
import care.ai.play2paycodingchallenge.databinding.EbayItemBinding
import care.ai.play2paycodingchallenge.models.EbayItem
import com.bumptech.glide.Glide

class EbayItemAdapter(var items:List<EbayItem>):RecyclerView.Adapter<EbayItemAdapter.EbayItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EbayItemVH {
        val binding: EbayItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.ebay_item, parent, false)
        return EbayItemVH(binding, parent.context)
    }

    override fun onBindViewHolder(holder: EbayItemVH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    class EbayItemVH(var binding: EbayItemBinding,var context: Context):RecyclerView.ViewHolder(binding.root){
        fun bind(item: EbayItem){
            binding.title.text = item.title
            binding.author.text = if (item.author != null) item.author else ""
            Glide.with(context).load(item.imageURL).override(50,50).into(binding.ebayImage)
        }
    }
}