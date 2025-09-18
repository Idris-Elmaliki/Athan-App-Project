package com.example.athanapp.ui

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.athanapp.R
import com.example.athanapp.data.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingOptionsScreen(
    returnToSettings : () -> Unit,
    @StringRes screenName : Int,
) {
    Scaffold(
        topBar = {
            SettingsOptions_TopBar(
                toSettingsPage = returnToSettings,
                screenName = screenName,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.medium_padding))
            )
        }
    ) { innerpadding ->
        when (screenName) {
            R.string.general -> {}
            R.string.appearance -> {}
            R.string.sound -> {}
            R.string.lang -> {}
            R.string.notification -> {}
            R.string.location -> {}
            R.string.info -> {}
        }
    }
}

@Composable
private fun SettingsOptions_TopBar(
    toSettingsPage : () -> Unit,
    @StringRes screenName : Int,
    modifier : Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IconButton(
            onClick = toSettingsPage,
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .size(size = dimensionResource(R.dimen.navigation_icon_size))
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = stringResource(screenName),
                style = MaterialTheme.typography.displaySmall
            )
        }
        Spacer(modifier = Modifier.size(dimensionResource(R.dimen.navigation_icon_size)))
    }
}

@Composable
private fun SettingOptionsLayout(
    itemContent: List<SettingOptionsFunc>,
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = padding,
        modifier = modifier
    ) {
        items(itemContent) { funcData ->
            funcData.func(
                Modifier
                    .padding(
                        top = dimensionResource(R.dimen.small_padding),
                        bottom = dimensionResource(R.dimen.small_padding)
                    )
                    .statusBarsPadding()
                    .navigationBarsPadding()
            )
        }
    }
}