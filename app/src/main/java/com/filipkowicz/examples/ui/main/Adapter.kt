package com.filipkowicz.examples.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.filipkowicz.examples.R

class Adapter
    : ListAdapter<ListItem, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<ListItem>() {
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.itemType == newItem.itemType
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem == newItem
    }
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            R.layout.item_layout -> LayoutInflater.from(parent.context).inflate(
                viewType,
                parent,
                false
            )
            R.layout.header_layout -> LayoutInflater.from(parent.context).inflate(
                viewType,
                parent,
                false
            )
            else -> throw IllegalArgumentException("no supported item id")
        }.let {
            object : RecyclerView.ViewHolder(it) {}
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder.itemView as? TextView)?.text = (getItem(position) as? MainViewModel.Data)?.data
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).itemType
    }
}