package com.ankhi.weather.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ankhi.weather.models.ForecastModel
import com.ankhi.weather.databinding.ForecastItemRowBinding


class ForecastAdapter : ListAdapter<ForecastModel.ForecastList, ForecastAdapter.ForecastViewholder>(ForecastDiffUtil()){

    class ForecastViewholder(val binding: ForecastItemRowBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(item: ForecastModel.ForecastList) {
                    binding.item = item
                }
            }

    class ForecastDiffUtil : DiffUtil.ItemCallback<ForecastModel.ForecastList>() {
        override fun areItemsTheSame(
            oldItem: ForecastModel.ForecastList,
            newItem: ForecastModel.ForecastList
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ForecastModel.ForecastList,
            newItem: ForecastModel.ForecastList
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewholder {
        val binding = ForecastItemRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ForecastViewholder(binding)
    }

    override fun onBindViewHolder(holder: ForecastViewholder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}