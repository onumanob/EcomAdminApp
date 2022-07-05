package com.ashik.ecomadminbatch04.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ashik.ecomadminbatch04.models.DashboardItem
import com.ashik.ecomadminbatch04.models.DashboardItemType
import com.ashik.ecomadminbatch04.models.dashboardItemList
import com.ashik.ecomadminbatch04.databinding.DashboardItemBinding


class DashboardItemAdapter(val callback: (DashboardItemType) -> Unit) : RecyclerView.Adapter<DashboardItemAdapter.DashboardViewHolder>(){

    class DashboardViewHolder(val binding: DashboardItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: DashboardItem) {
                binding.item = item
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val binding = DashboardItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return DashboardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.bind(dashboardItemList.get(position))
        holder.itemView.setOnClickListener {
            callback(dashboardItemList.get(position).type)
        }
    }

    override fun getItemCount() = dashboardItemList.size
}