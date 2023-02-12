package com.masharo.doubletapp.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.masharo.doubletapp.log.LifecycleEventLogger
import com.masharo.doubletapp.ui.screen.SquareScreen
import com.masharo.doubletapp.ui.theme.DoubletappTheme
import kotlin.math.pow
import kotlin.math.roundToInt

class SquareActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val value = intent.getIntExtra(PARAM_VALUE, 0)
        val square = value.toDouble().pow(2.0).roundToInt()

        setContent {
            DoubletappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SquareScreen(square = square.toString())
                }
            }
        }

        lifecycle.addObserver(
            LifecycleEventLogger(componentName.className)
        )
    }

    companion object {
        const val PARAM_VALUE = "PARAM_VALUE"
    }
}