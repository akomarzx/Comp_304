package com.example.excercise1.data

import com.example.excercise1.R

object AttractionDataSource {
    fun getAttraction() : List<AttractionInformation> {
        val locationType = arrayListOf(
            AttractionInformation(1, "CN Tower - 290 Bremner Blvd, Toronto, ON M5V 3L9", 43.6426, -79.387054, LocationType.Attractions, R.drawable.logo),
            AttractionInformation(2, "Casa Loma - 1 Austin Terrace, Toronto, ON M5R 1X8",  43.678055,   -79.409538, LocationType.Attractions, R.drawable.logo),
            AttractionInformation(3, "ROM - 100 Queens Park, Toronto, ON M5S 2C6", 43.667713, -79.394913, LocationType.Museum,R.drawable.logo),
            AttractionInformation(4, "AGO - 317 Dundas St W, Toronto, ON M5T 1G4", 43.6536, -79.3925, LocationType.Museum, R.drawable.logo),
            AttractionInformation(5, "Scotiabank Arena - 40 Bay St, Toronto, ON M5S 1A1", 43.643475, -79.379379, LocationType.Stadiums,R.drawable.logo),
            AttractionInformation(6, "Rogers Centre - 1000 Yonge St, Toronto, ON M5R 2N6", 43.6416, 79.3894, LocationType.Stadiums,R.drawable.logo),
        )
        return locationType
    }

    fun getAttractionType() : List<AttractionTypeInformation> {
        val locationType = arrayListOf(
            AttractionTypeInformation(1, "Museum", LocationType.Museum, R.drawable.museum),
            AttractionTypeInformation(2, "Attractions", LocationType.Attractions, R.drawable.museum),
            AttractionTypeInformation(3, "Stadiums", LocationType.Stadiums,R.drawable.museum),
        )
        return locationType
    }

    fun getAttractionByType(type: LocationType?) : List<AttractionInformation> {
        return getAttraction().filter { it.locationType == type }
    }


}