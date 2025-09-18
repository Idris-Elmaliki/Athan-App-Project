package com.example.athanapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.athanapp.R
import com.example.athanapp.AthanAppScreens
data class SettingsOptions(
    @DrawableRes val optionsIcon : Int,
    @StringRes val optionsName : Int,
    @StringRes val optionsDesc : Int,
    val optionName : String
)

data class SettingOptionsFunc(
    val func : @Composable (modifier : Modifier) -> Unit
)

val headerList = listOf(
    SettingsOptions(
        R.drawable.settings,
        R.string.general,
        R.string.general_desc,
        AthanAppScreens.General.name
    ),
    SettingsOptions(
        R.drawable.image_02,
        R.string.appearance,
        R.string.appearance_desc,
        AthanAppScreens.Appearance.name
    ),
    SettingsOptions(
        R.drawable.volume_max,
        R.string.sound,
        R.string.sound_desc,
        AthanAppScreens.Sound.name
    ),
    SettingsOptions(
        R.drawable.font,
        R.string.lang,
        R.string.lang_desc,
        AthanAppScreens.Lang.name
    ),
    SettingsOptions(
        R.drawable.bell,
       R.string.notification,
        R.string.notif_desc,
        AthanAppScreens.Notif.name
    ),
    SettingsOptions(
        R.drawable.navigation,
        R.string.location,
        R.string.location_desc,
        AthanAppScreens.Location.name
    ),
    SettingsOptions(
        R.drawable.info,
        R.string.info,
        R.string.info_desc,
        AthanAppScreens.Info.name
    )
)