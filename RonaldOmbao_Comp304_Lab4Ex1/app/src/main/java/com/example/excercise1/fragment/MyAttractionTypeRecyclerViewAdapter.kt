package com.example.excercise1.fragment

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.excercise1.R
import com.example.excercise1.data.AttractionTypeInformation

import com.example.excercise1.fragment.placeholder.PlaceholderContent.PlaceholderItem
import com.example.excercise1.databinding.FragmentAttractionTypeListItemBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyAttractionTypeRecyclerViewAdapter(
    private val values: List<AttractionTypeInformation>, private val listener: OnItemClickListener
) : RecyclerView.Adapter<MyAttractionTypeRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentAttractionTypeListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.attractionTypeId.toString()
        holder.contentView.text = item.attractionTypeName

        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentAttractionTypeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: AttractionTypeInformation)
    }
}