package com.example.lovecounter.onBoarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lovecounter.R
import com.example.lovecounter.databinding.ItemOnBoardingBinding

class OnBoardingAdapter(
    val onClick: () -> Unit
) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val arrayList = arrayListOf(
        OnBoarding(R.drawable.love_picture, "It's Funs and Many more"),
        OnBoarding( R.drawable.good_time,"Have a good time","You should take the time to help those who need you"),
        OnBoarding( R.drawable.cherishing_love,"Cherishing love","It is now no longer possible for you to cherish love"),
        OnBoarding( R.drawable.hello,"Have a breakup?","We have made the correction for you don't worry")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int = arrayList.size

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {
            binding.textSkip.setOnClickListener {
                onClick()
            }
            binding.btnStart.setOnClickListener {
                onClick()
            }
            binding.btnStart.isVisible = adapterPosition == arrayList.lastIndex
            binding.textSkip.isVisible = adapterPosition != arrayList.lastIndex
            binding.titleBoarding.text = onBoarding.title
            binding.textBoarding.text = onBoarding.text
            binding.onBoardingImg.load(onBoarding.image)
        }
    }
}