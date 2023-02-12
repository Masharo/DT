package com.masharo.doubletapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.masharo.doubletapp.ui.screen.NumberScreen
import com.masharo.doubletapp.ui.theme.DoubletappTheme
import com.masharo.doubletapp.log.LifecycleEventLogger

class NumberActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoubletappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NumberScreen { value ->
                        startActivity(
                            Intent(applicationContext, SquareActivity::class.java)
                                .putExtra(SquareActivity.PARAM_VALUE, value)
                        )
                    }
                }
            }
        }

        lifecycle.addObserver(
            LifecycleEventLogger(componentName.className)
        )
    }
}