package com.masharo.doubletapp.log

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class LifecycleEventLogger(
    private val title: String
) : LifecycleEventObserver {

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.d(LOG_TAG, "$title: ${event.name}")
    }

    companion object {
        const val LOG_TAG = "LifecycleEventLogger"
    }

}