package com.example.athanapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.athanapp.ui.AthanScreen
import com.example.athanapp.ui.QiblaFinderScreen
import com.example.athanapp.ui.theme.AthanAppTheme
import com.example.athanapp.ui.SettingsScreen
import com.example.athanapp.ui.SettingOptionsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AthanAppTheme {
                Surface {
                    AppLayout(
                        modifier = Modifier
                            .navigationBarsPadding()
                            .statusBarsPadding()
                    )
                }
            }
        }
    }
}

enum class AthanAppScreens() {
    Main,
        QiblaFinder,
    Settings,
        General,
        Appearance,
        Sound,
        Lang,
        Notif,
        Location,
        Info,
}

@Composable
fun AppLayout(
    modifier: Modifier = Modifier,
    navController : NavHostController = rememberNavController()
) {
    Scaffold(
        modifier = modifier
    ) { innerpadding ->
        NavHost(
            navController = navController,
            startDestination = AthanAppScreens.Main.name,
            modifier = Modifier
                .padding(innerpadding)
        ) {
            composable(route = AthanAppScreens.Main.name) {
                AthanScreen(
                    navigateToSettings = {
                        navController.navigate(AthanAppScreens.Settings.name)
                    },
                    navigateToQibla = {
                        navController.navigate(AthanAppScreens.QiblaFinder.name)
                    }
                )
            }
            navigation(
                startDestination = AthanAppScreens.Settings.name,
                route = "settings"
            ) {
                composable(route = AthanAppScreens.Settings.name) {
                    SettingsScreen(
                        navigateToAthanScreen = {
                            returnToAthanScreen(navController)
                        },
                        navController = navController,
                    )
                }
                composable(route = AthanAppScreens.General.name) {
                    SettingOptionsScreen(
                        returnToSettings = {
                            returnToSettingsScreen(navController)
                        },
                        screenName = R.string.general,
                    )
                }
                composable(route = AthanAppScreens.Appearance.name) {
                    SettingOptionsScreen(
                        returnToSettings = {
                            returnToSettingsScreen(navController)
                        },
                        screenName = R.string.appearance
                    )
                }
                composable(route = AthanAppScreens.Sound.name) {
                    SettingOptionsScreen(
                        returnToSettings = {
                            returnToSettingsScreen(navController)
                        },
                        screenName = R.string.sound
                    )
                }
                composable(route = AthanAppScreens.Lang.name) {
                    SettingOptionsScreen(
                        returnToSettings = {
                            returnToSettingsScreen(navController)
                        },
                        screenName = R.string.lang
                    )
                }
                composable(route = AthanAppScreens.Notif.name) {
                    SettingOptionsScreen(
                        returnToSettings = {
                            returnToSettingsScreen(navController)
                        },
                        screenName = R.string.notification
                    )
                }
                composable(route = AthanAppScreens.Location.name) {
                    SettingOptionsScreen(
                        returnToSettings = {
                            returnToSettingsScreen(navController)
                        },
                        screenName = R.string.location
                    )
                }
                composable(route = AthanAppScreens.Info.name) {
                    SettingOptionsScreen(
                        returnToSettings = {
                            returnToSettingsScreen(navController)
                        },
                        screenName = R.string.info
                    )
                }
            }
            composable(route = AthanAppScreens.QiblaFinder.name) {
                QiblaFinderScreen(
                    returnToAthan = {
                      returnToAthanScreen(navController)
                    }
                )
            }
        }
    }
}

private fun returnToAthanScreen(
    navController : NavHostController
) {
    navController.popBackStack(AthanAppScreens.Main.name, false)
}

private fun returnToSettingsScreen(
    navController : NavHostController
) {
    navController.popBackStack(AthanAppScreens.Settings.name, false)
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Testing"
)
@Composable
fun GreetingPreview() {
    AthanAppTheme {
        AppLayout()
    }
}