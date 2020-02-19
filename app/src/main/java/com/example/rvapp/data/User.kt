package com.example.rvapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val title: String,
    val name: String,
    val lastname: String,
    val email: String,
    val phone: String,
    val photo: String
) : Parcelable {
}