package com.example.excercise1.data

import android.os.Parcel
import android.os.Parcelable

class AttractionTypeInformation(val attractionTypeId : Int, val attractionTypeName: String, val locationType: LocationType, val imgResID : Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        LocationType.valueOf(parcel.readString().toString()),
        parcel.readInt()
    ) {
    }

    override fun describeContents(): Int {
        return 0;
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(attractionTypeName)
        dest.writeString(locationType.name)
        dest.writeInt(attractionTypeId)
        dest.writeInt(imgResID)
    }

    companion object CREATOR : Parcelable.Creator<AttractionTypeInformation> {
        override fun createFromParcel(parcel: Parcel): AttractionTypeInformation {
            return AttractionTypeInformation(parcel)
        }

        override fun newArray(size: Int): Array<AttractionTypeInformation?> {
            return arrayOfNulls(size)
        }
    }

}
