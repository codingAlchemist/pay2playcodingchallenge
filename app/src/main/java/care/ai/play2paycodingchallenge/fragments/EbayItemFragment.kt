package care.ai.play2paycodingchallenge.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import care.ai.play2paycodingchallenge.R
import care.ai.play2paycodingchallenge.adapters.EbayItemAdapter
import care.ai.play2paycodingchallenge.databinding.FragmentEbayItemsBinding
import care.ai.play2paycodingchallenge.service.ApiService
import care.ai.play2paycodingchallenge.viewmodels.EbayItemViewModel

class EbayItemFragment:Fragment() {

    private val viewModel:EbayItemViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentEbayItemsBinding.inflate(LayoutInflater.from(requireContext()))
        binding.ebayItemRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.items.observe(viewLifecycleOwner, Observer {
            val adapter = EbayItemAdapter(it)
            binding.ebayItemRecyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        ApiService.getEbayItems(onSuccess = {
            viewModel.setItems(it)
        }, onFailure = {
            reportError(it)
        })
    }

    fun reportError(throwable: Throwable){
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.error))
            .setMessage(throwable.localizedMessage)
            .show()

    }

    companion object{
        fun newInstance() = EbayItemFragment()
    }
}