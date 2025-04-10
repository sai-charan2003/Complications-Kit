package com.charan.complicationskit.utils

import android.content.ComponentName
import android.content.Context
import android.util.Log
import androidx.wear.watchface.complications.datasource.ComplicationDataSourceService
import androidx.wear.watchface.complications.datasource.ComplicationDataSourceUpdateRequester

object ComplicationUtils {
    const val TAG = "ComplicationUtils"
    fun updateComplication(context: Context, complicationService: Class<out ComplicationDataSourceService>) {
        try {
            val component = ComponentName(context, complicationService)
            val updateRequester = ComplicationDataSourceUpdateRequester.create(context, component)
            updateRequester.requestUpdateAll()
            Log.d(TAG, "Requested update for ${component.className}")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to update complication", e)
        }
    }
}