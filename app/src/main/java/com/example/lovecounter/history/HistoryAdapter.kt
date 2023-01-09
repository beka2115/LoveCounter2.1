package com.example.lovecounter.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecounter.databinding.ItemHistoryBinding
import com.example.lovecounter.remote.LoveModel

class HistoryAdapter() : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val historyList: ArrayList<LoveModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(historyList[position])
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    fun addHistory(history: List<LoveModel>) {
        this.historyList.clear()
        this.historyList.addAll(history)
        notifyDataSetChanged()
    }

    class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(history: LoveModel) {
            binding.firstName.text = history.firstName
            binding.secondName.text = history.secondName
            binding.result.text = history.result
            binding.percentage.text = history.percentage


        }

    }
}