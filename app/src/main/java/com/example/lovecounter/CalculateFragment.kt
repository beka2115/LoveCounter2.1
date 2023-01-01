package com.example.lovecounter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecounter.databinding.FragmentCalculateBinding


class CalculateFragment : Fragment() {
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
        initClicker()

    }

    private fun initClicker() {
        with(binding) {

            calculateBtn.setOnClickListener {
                viewModel.getLiveLoveModel(
                    firstNameEd.text.toString(),
                    secondNameEd.text.toString()
                ).observe(
                    viewLifecycleOwner
                ) {
                    sendData(it.percentage, it.result, it.firstName, it.secondName)
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