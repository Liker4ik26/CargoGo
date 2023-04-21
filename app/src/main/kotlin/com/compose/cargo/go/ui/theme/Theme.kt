package com.compose.cargo.go.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.core.view.WindowCompat
import com.compose.cargo.go.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    onTertiary = GraytTS,
    background = ChineseBlack,
    onPrimary = DarkCornflowerBlue,
    onSecondary = MetallicBlue,
    onBackground = RaisinBlack,
    onSurface = Gray
)

private val LightColorScheme = lightColorScheme(
    primary = ChineseBlack,
    background = BgWhite,
    onTertiary = GraytTS,
    onPrimary = DarkCornflowerBlue,
    onSecondary = MetallicBlue,
    onBackground = Color.White,
    onSurface = Gray
)

@Composable
fun CargoGoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val view = LocalView.current
    (view.context as? Activity)?.window
        ?: throw Exception(stringResource(R.string.window_exception))
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    systemUiController.setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = !darkTheme,
    )
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
        shapes = Shapes
    )
}