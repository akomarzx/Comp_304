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
import com.example.excercise1.activity.MapsActivity
import com.example.excercise1.data.AttractionDataSource
import com.example.excercise1.data.AttractionInformation
import com.example.excercise1.data.AttractionTypeInformation
import com.example.excercise1.data.LocationType

/**
 * A fragment representing a list of Items.
 */
class AttractionListFragment : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_attraction_list, container, false)

        val attractionTypeStr = arguments?.getString("type")

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                val type : LocationType? = attractionTypeStr?.let { LocationType.valueOf(it) }
                adapter = activity?.let {
                    AttractionItemRecyclerViewAdapter(AttractionDataSource.getAttractionByType(type), it, object : AttractionItemRecyclerViewAdapter.OnItemClickListener {
                        override fun onItemClick(item: AttractionInformation) {
                            val intent = Intent(requireContext(), MapsActivity::class.java)
                            intent.putExtra("longitude", item.longitude) // Replace with actual longitude
                            intent.putExtra("latitude", item.latitude)
                            intent.putExtra("name", item.name)
                            startActivity(intent)
                        }
                    })
                }
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
            AttractionListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}