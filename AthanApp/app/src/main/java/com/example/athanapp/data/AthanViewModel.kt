package com.example.athanapp.data

import androidx.lifecycle.ViewModel

class AthanViewModel : ViewModel() {
    data class AthanTimes(
        val Fajr : String,
        val Zuhr : String,
        val Asr : String,
        val Maghrib : String,
        val Isha : String
    )

}