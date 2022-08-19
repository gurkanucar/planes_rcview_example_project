package com.gusoft.planes_rcview_example_project

import android.os.Parcel
import android.os.Parcelable

data class PlaneModel(
    val name: String?,
    val image: Int,
    val country: String?,
    val cost: Double,
    val speed: Int,
    val range: Int,
    val date: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(image)
        parcel.writeString(country)
        parcel.writeDouble(cost)
        parcel.writeInt(speed)
        parcel.writeInt(range)
        parcel.writeString(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlaneModel> {
        override fun createFromParcel(parcel: Parcel): PlaneModel {
            return PlaneModel(parcel)
        }

        override fun newArray(size: Int): Array<PlaneModel?> {
            return arrayOfNulls(size)
        }
    }
}
