package viet.hoang.automationproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import viet.hoang.automationproject.R
import viet.hoang.automationproject.databinding.HistoryResultItemBinding
import viet.hoang.automationproject.models.ResultHistory
import java.util.*

class HistoryAdapter(
    var dataSet: List<ResultHistory> = listOf()
) : RecyclerView.Adapter<HistoryAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HistoryResultItemBinding.inflate(inflater,parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind(dataSet[position])

    override fun getItemCount(): Int {
        return dataSet.count();
    }

    class ItemViewHolder(val binding : HistoryResultItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResultHistory) {
            binding.item = item
            binding.executePendingBindings()
        }

    }
}
