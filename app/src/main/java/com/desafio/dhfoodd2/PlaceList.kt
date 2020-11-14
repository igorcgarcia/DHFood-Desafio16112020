package com.desafio.dhfoodd2

import android.os.Parcel
import android.os.Parcelable

@Parcelize
data class Places(
    val placeImage: String?,
    val placeName: String?,
    val placeAddress: String?,
    val placeClose: String?
) :Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(placeImage)
        parcel.writeString(placeName)
        parcel.writeString(placeAddress)
        parcel.writeString(placeClose)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Places> {
        override fun createFromParcel(parcel: Parcel): Places {
            return Places(parcel)
        }

        override fun newArray(size: Int): Array<Places?> {
            return arrayOfNulls(size)
        }
    }
}

annotation class Parcelize
