package care.ai.play2paycodingchallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import care.ai.play2paycodingchallenge.databinding.EbayItemBinding
import care.ai.play2paycodingchallenge.models.EbayItem
import com.squareup.picasso.Picasso

class EbayItemAdapter(var items:List<EbayItem>):RecyclerView.Adapter<EbayItemAdapter.EbayItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EbayItemVH {
        val binding: EbayItemBinding = EbayItemBinding.inflate(LayoutInflater.from(parent.context))
        return EbayItemVH(binding)
    }

    override fun onBindViewHolder(holder: EbayItemVH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    class EbayItemVH(var binding: EbayItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: EbayItem){
            binding.title.text = item.title
            binding.author.text = if (item.author.isNotEmpty()) item.author else ""
            Picasso.with(binding.root.context).load(item.imageURL).into(binding.ebayImage)
        }
    }
}