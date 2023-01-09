package com.example.lovecounter.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecounter.LoveViewModel
import com.example.lovecounter.Pref
import com.example.lovecounter.R
import com.example.lovecounter.databinding.FragmentCalculateBinding
import com.example.lovecounter.di.App
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CalculateFragment : Fragment() {

    @Inject
    lateinit var pref: Pref
    private lateinit var binding: FragmentCalculateBinding
    private val viewModel: LoveViewModel by viewModels()

    companion object {
        const val KEY_FOR_PERCENTAGE = "key1"
        const val KEY_FOR_RESULT = "key2"
        const val KEY_FOR_SECOND_NAME = "key3"
        const val KEY_FOR_FIRST_NAME = "key4"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref.onPref(requireContext())
        if (pref.isOnBoardingShow()) {
            findNavController().navigate(R.id.onBoardingFragment)
        }
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            historyBtn.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
            calculateBtn.setOnClickListener {
                viewModel.getLiveLoveModel(
                    firstNameEd.text.toString(),
                    secondNameEd.text.toString()
                ).observe(
                    viewLifecycleOwner
                ) {
                    sendData(it.percentage, it.result, it.firstName, it.secondName)
                    App.appDataBase.getDao().insertLove(it)
                }
            }
        }
    }


    private fun sendData(
        percentageNum: String,
        result: String,
        firstName: String,
        secondName: String
    ) {
        findNavController().navigate(
            R.id.resultFragment,
            bundleOf(
                KEY_FOR_PERCENTAGE to percentageNum, KEY_FOR_RESULT to result,
                KEY_FOR_FIRST_NAME to firstName, KEY_FOR_SECOND_NAME to secondName
            )
        )
    }


}