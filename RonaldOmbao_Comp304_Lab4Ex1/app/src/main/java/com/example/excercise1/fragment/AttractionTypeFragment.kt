package com.example.excercise1.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.excercise1.R
import com.example.excercise1.activity.AttractionListActivity
import com.example.excercise1.data.AttractionDataSource
import com.example.excercise1.data.AttractionTypeInformation
import com.example.excercise1.fragment.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class AttractionTypeFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_attraction_type_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyAttractionTypeRecyclerViewAdapter(AttractionDataSource.getAttractionType(), object : MyAttractionTypeRecyclerViewAdapter.OnItemClickListener {
                    override fun onItemClick(item: AttractionTypeInformation) {
                        Toast.makeText(requireContext(), "Clicked: ${item.attractionTypeName}", Toast.LENGTH_SHORT).show()
                        val intent = Intent(requireContext(), AttractionListActivity::class.java)
                        intent.putExtra("type", item.attractionTypeName)
                        startActivity(intent)
                    }
                })
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            AttractionTypeFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}