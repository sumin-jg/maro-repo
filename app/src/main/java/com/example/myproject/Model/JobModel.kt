package com.example.myproject.Model

import android.os.Parcel
import android.os.Parcelable

data class JobModel(
    val title: String = "",
    val company: String = "",
    val picURL: String = "",
    val time: String = "",
    val model: String = "",
    val level: String = "",
    val location: String = "",
    val category: String = "",
    val about: String = "",
    val description: String = "",
    val salary: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        "\$38k ~ \$46K"
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(company)
        parcel.writeString(picURL)
        parcel.writeString(time)
        parcel.writeString(model)
        parcel.writeString(level)
        parcel.writeString(location)
        parcel.writeString(category)
        parcel.writeString(about)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<JobModel> {
        override fun createFromParcel(parcel: Parcel): JobModel {
            return JobModel(parcel)
        }

        override fun newArray(size: Int): Array<JobModel?> {
            return arrayOfNulls(size)
        }
    }
}