package dev.helw.playground.sdui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.design.core.IconToken

internal val NavigationGraph = listOf(
    Destination(
        title = "Native List",
        subtitle = "A list built natively",
        icon = IconToken.LIST,
        content = { /* TODO */ }
    ),
    Destination(
        title = "Server Driven List",
        subtitle = "A list rendered via json response",
        icon = IconToken.SETTINGS,
        content = { /* TODO */ }
    ),
)

data class Destination(
    val title: String,
    val subtitle: String,
    val icon: IconToken,
    val content: @Composable (Modifier) -> Unit = {},
) {
    val route: String by lazy {
        title.lowercase()
            .replace(Regex("\\W+"), "")
            .replace(Regex("\\s+"), "_")
    }
}