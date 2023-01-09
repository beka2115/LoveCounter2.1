package com.example.lovecounter.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecounter.databinding.FragmentHistoryBinding
import com.example.lovecounter.di.App

class HistoryFragment : Fragment() {
    private lateinit var adapter: HistoryAdapter
    lateinit var binding: FragmentHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = HistoryAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data= App.appDataBase.getDao().getAll()
        adapter.addHistory(data)
        binding.historyRecycler.adapter = adapter


    }


}