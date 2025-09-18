package com.example.athanapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import com.example.athanapp.data.headerList
import com.example.athanapp.data.SettingsOptions
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import com.example.athanapp.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SettingsScreen(
    navController : NavHostController,
    navigateToAthanScreen : () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            Settings_TopBar(
                toAthanPage = navigateToAthanScreen,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.medium_padding))
            )
        },
        modifier = modifier
    ) { topBarPadding ->
        LazyColumn(
            contentPadding = topBarPadding,
            modifier = Modifier
        ) {
            item {
                Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.small_padding)))
            }
            items(headerList) { data ->
                SettingsCards(
                    onCLick =  { navController.navigate(data.optionName) },
                    optionsData = data,
                    modifier = Modifier
                        .navigationBarsPadding()
                        .safeContentPadding()
                        .statusBarsPadding()
                        .padding(
                            top = dimensionResource(R.dimen.small_padding),
                            bottom = dimensionResource(R.dimen.small_padding)
                        )
                )
            }
        }
    }
}

@Composable
private fun Settings_TopBar(
    toAthanPage : () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        IconButton(
            onClick = toAthanPage,
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
                text = stringResource(R.string.Settings),
                style = MaterialTheme.typography.displaySmall,
            )
        }
        Spacer(modifier = Modifier.size(dimensionResource(R.dimen.navigation_icon_size)))
    }
}

@Composable
private fun SettingsCards(
    onCLick : () -> Unit,
    optionsData : SettingsOptions,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onCLick,
        shape = MaterialTheme.shapes.small,
        colors = ButtonColors(
            containerColor = Color(0xFF303030),
            contentColor = MaterialTheme.colorScheme.onBackground,
            disabledContentColor = MaterialTheme.colorScheme.background,
            disabledContainerColor = MaterialTheme.colorScheme.onBackground
        ),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    top = dimensionResource(R.dimen.small_padding),
                    bottom = dimensionResource(R.dimen.small_padding)
                )
        ) {
            Icon(
                painter = painterResource(optionsData.optionsIcon),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = dimensionResource(R.dimen.medium_padding))
                    .size(dimensionResource(R.dimen.navigation_icon_size))
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(optionsData.optionsName),
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 20.sp
                )
                Text(
                    text = stringResource(optionsData.optionsDesc),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}
