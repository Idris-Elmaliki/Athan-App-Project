package com.example.athanapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.athanapp.R
import com.example.athanapp.data.AthanTimesInfo
import com.example.athanapp.data.loadAthanTimesList
import kotlinx.coroutines.delay
import java.text.DateFormat
import java.util.Calendar

@Composable
fun AthanScreen(
    navigateToSettings : () -> Unit,
    navigateToQibla : () -> Unit,
    modifier : Modifier = Modifier
) {
    Scaffold(
        topBar = {
            AthanPage_TopBar(
                onClick = navigateToSettings,
                modifier = Modifier
                    .padding(
                        dimensionResource(R.dimen.medium_padding)
                    )
            )
        },
        modifier = modifier
        ) { innerpadding ->
        LazyColumn(
            contentPadding = innerpadding,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                CurrentDayText()
                CurrentLocation()
            }
            items(loadAthanTimesList)  { times ->
                AthanCards(
                    athanTimesData = times,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = dimensionResource(R.dimen.small_padding),
                            start = dimensionResource(R.dimen.medium_padding),
                            end = dimensionResource(R.dimen.medium_padding),
                        )
                )
            }
            item {
                QiblaButton(
                    onClick = navigateToQibla,
                    modifier = Modifier
                        .padding(top = dimensionResource(R.dimen.small_padding))
                )
            }
        }
    }
}

@Composable
private fun AthanPage_TopBar(
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Spacer(
            modifier = Modifier
                .size(dimensionResource(R.dimen.navigation_icon_size))
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = stringResource(R.string.AthanPage),
                style = MaterialTheme.typography.displaySmall
            )
        }
        IconButton(
            onClick = onClick
        ) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "To Settings",
                modifier = Modifier.size(size = dimensionResource(R.dimen.navigation_icon_size))
            )
        }
    }
}

@Composable
private fun AthanCards(
    athanTimesData : AthanTimesInfo,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(dimensionResource(R.dimen.small_padding))
    ) {
        Card(
            modifier = modifier
        ) {
            Row(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.small_padding)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(athanTimesData.prayerImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.imageSizes))
                        .clip(shape = MaterialTheme.shapes.medium)
                )
                Text(
                    text = stringResource(athanTimesData.prayerName),
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(R.dimen.small_padding),
                            end = dimensionResource(R.dimen.small_padding)
                        )
                        .weight(1f)
                )
                CurrentTimeText() // placeholder for Athan Times
            }
        }
    }
}

@Composable
private fun QiblaButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.small_padding))
        ) {
            Image(
                painter = painterResource(R.drawable.qibla_compass),
                contentDescription = null,
                modifier = Modifier
                    .size(size = dimensionResource(R.dimen.imageSizes))
                    .padding(bottom = dimensionResource(R.dimen.small_padding))
            )
            Text(
                text = stringResource(R.string.QiblaFinder),
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .background(
                        shape = MaterialTheme.shapes.medium,
                        color = MaterialTheme.colorScheme.secondaryContainer
                    )
                    .padding(dimensionResource(R.dimen.extra_small_padding))
            )
        }

    }
}
@Composable
private fun CurrentLocation() {
    Text(
        text = stringResource(R.string.Current_Location)
    )
}

@Composable
private fun CurrentTimeText() {
    var time by remember { mutableStateOf(CurrentTime())}

    LaunchedEffect(Unit) {
        while (true) {
            time = CurrentTime()
            delay(100L)
        }
    }

    Text(
        text = time,
        style = MaterialTheme.typography.displaySmall,
    )
}

@Composable
private fun CurrentDayText() {
    var date by remember { mutableStateOf(CurrentDay()) }

    LaunchedEffect(Unit) {
        while(true) {
            date = CurrentDay()
            delay(60000)
        }
    }

    Text(
        text = date,
        style = MaterialTheme.typography.displaySmall,
    )
}


// these functions will later be added to the viewModel class when it gets created
private fun CurrentDay() : String {
    val day = Calendar.getInstance().time
    val dayFormat = DateFormat.getDateInstance(DateFormat.SHORT).format(day)

    return dayFormat
}

/*
CurrentTime is a placeholder, will have proper times for each prayer soon!!!
*/
private fun CurrentTime() : String {
    val time = Calendar.getInstance().time
    val timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT).format(time)

    return timeFormat
}