package com.example.athanapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.athanapp.R
data class AthanTimesInfo(
    @StringRes val prayerName : Int,
    @DrawableRes val prayerImage : Int
)
val loadAthanTimesList = listOf(
    AthanTimesInfo(
        prayerName = R.string.fajr,
        prayerImage = R.drawable.athanapp_fajr
    ),
    AthanTimesInfo(
        prayerName = R.string.zuhr,
        prayerImage = R.drawable.athanapp_zuhr
    ),
    AthanTimesInfo(
        prayerName = R.string.asr,
        prayerImage = R.drawable.athanapp_asr
    ),
    AthanTimesInfo(
        prayerName = R.string.magarib,
        prayerImage = R.drawable.athanapp_magarib
    ),
    AthanTimesInfo(
        prayerName = R.string.isha,
        prayerImage = R.drawable.athanapp_isha
    )
)


