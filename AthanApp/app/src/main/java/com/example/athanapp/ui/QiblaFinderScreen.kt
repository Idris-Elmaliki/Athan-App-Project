package com.example.athanapp.ui

import android.annotation.SuppressLint
import com.example.athanapp.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QiblaFinderScreen(
    returnToAthan : () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            Qibla_TopBar(
                returnToAthan,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.medium_padding))
            )
        }
    ) {

    }
}

@Composable
private fun Qibla_TopBar(
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IconButton(
            onClick = onClick
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.navigation_icon_size))
            )
        }
    }
}