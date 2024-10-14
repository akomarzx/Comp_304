package com.example.excercise1.fragment

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.excercise1.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private var latitude : Double = 0.0
    private var longitude : Double = 0.0
    private var name : String = ""
    private val callback = OnMapReadyCallback { googleMap ->

        longitude = arguments?.getDouble("longitude")!!
        latitude = arguments?.getDouble("latitude")!!
        name = arguments?.getString("name")!!

        val location = LatLng(latitude, longitude)
        googleMap.addMarker(MarkerOptions().position(location).title("Marker in $name"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(location))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
        googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

}