package com.example.lovecounter.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecounter.Pref
import com.example.lovecounter.R
import com.example.lovecounter.databinding.FragmentOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint
import me.relex.circleindicator.CircleIndicator3
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    @Inject
    lateinit var pref: Pref
    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var adapter: OnBoardingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref.onPref(requireContext())
        adapter = OnBoardingAdapter {
            pref.saveShowBoarding(false)
            findNavController().navigateUp()
        }
        binding.pager.adapter = adapter
        val indicator=view.findViewById<CircleIndicator3>(R.id.circle_indicator)
        indicator.setViewPager(binding.pager)
    }

}