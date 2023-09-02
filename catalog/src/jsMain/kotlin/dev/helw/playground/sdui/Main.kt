package dev.helw.playground.sdui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.CanvasBasedWindow
import dev.helw.playground.sdui.design.core.color.LocalBackgroundColors
import dev.helw.playground.sdui.design.theme.AppTheme
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow {
            AppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    var destination by remember { mutableStateOf(NavigationGraph[0]) }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        MainDemo(
                            graph = NavigationGraph,
                            modifier = Modifier.weight(2f),
                            onClick = { destination = it })
                        Spacer(
                            modifier = Modifier
                                .width(1.dp)
                                .fillMaxHeight()
                                .background(color = LocalBackgroundColors.current.primary.color)
                        )
                        destination.content.invoke(
                            Modifier
                                .weight(3f)
                                .padding(horizontal = 16.dp)
                                .padding(top = 16.dp)
                        )
                    }
                }
            }
        }
    }
}