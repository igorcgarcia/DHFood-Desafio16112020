package com.desafio.dhfoodd2.model

import android.os.Parcel
import android.os.Parcelable

@Parcelize
data class Menus(
        val menuPlaceName: String?,
        val menuName: String?,
        val menuImage: String?,
        val MenuDescription: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(menuPlaceName)
        parcel.writeString(menuName)
        parcel.writeString(menuImage)
        parcel.writeString(MenuDescription)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Menus> {
        override fun createFromParcel(parcel: Parcel): Menus {
            return Menus(parcel)
        }

        override fun newArray(size: Int): Array<Menus?> {
            return arrayOfNulls(size)
        }
    }
}