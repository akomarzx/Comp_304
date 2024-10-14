package com.example.excercise1.fragment

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.excercise1.data.AttractionInformation
import com.example.excercise1.databinding.FragmentAttractionListItemBinding
import com.example.excercise1.fragment.MyAttractionTypeRecyclerViewAdapter.OnItemClickListener


/**
 */
class AttractionItemRecyclerViewAdapter(
    private val values: List<AttractionInformation>,
    private val context : Context,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<AttractionItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentAttractionListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.addressText.text = item.name
        holder.contentImage.setImageResource(item.imgResID)

        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentAttractionListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var addressText = binding.textAddress
        val contentImage: ImageView = binding.imageLogo
        override fun toString(): String {
            return super.toString()
        }

    }

    interface OnItemClickListener {
        fun onItemClick(item: AttractionInformation)
    }
}