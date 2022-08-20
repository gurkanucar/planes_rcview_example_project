package com.gusoft.planes_rcview_example_project

import kotlinx.parcelize.Parcelize
import android.os.Parcel
import android.os.Parcelable

@Parcelize
data class PlaneModel(
    val name: String?,
    val image: Int,
    val country: String?,
    val cost: Double,
    val speed: Int,
    val range: Int,
    val date: String?,
) : Parcelable