package com.charan.complicationskit.complication

import android.icu.util.Calendar
import android.util.Log
import androidx.wear.watchface.complications.data.ComplicationData
import androidx.wear.watchface.complications.data.ComplicationType
import androidx.wear.watchface.complications.data.MonochromaticImage
import androidx.wear.watchface.complications.data.PlainComplicationText
import androidx.wear.watchface.complications.data.ShortTextComplicationData
import androidx.wear.watchface.complications.datasource.ComplicationRequest
import androidx.wear.watchface.complications.datasource.SuspendingComplicationDataSourceService
import com.charan.complicationskit.utils.DateUtils

class DayDateComplicationService : SuspendingComplicationDataSourceService() {

    override fun getPreviewData(type: ComplicationType): ComplicationData? {
        if (type != ComplicationType.SHORT_TEXT) {
            return null
        }
        return createComplicationData("Mon", "Monday")
    }

    override suspend fun onComplicationRequest(request: ComplicationRequest): ComplicationData {
        Log.d("TAG", "onComplicationRequest: ${Calendar.HOUR_OF_DAY}")
        return createComplicationData(DateUtils.getCurrentDay(), DateUtils.getMonthAndDay())
    }


    private fun createComplicationData(day : String, date: String) =
        ShortTextComplicationData
            .Builder(
            text = PlainComplicationText.Builder(date).build(),
            contentDescription = PlainComplicationText.Builder("date").build()
            )
            .setMonochromaticImage(MonochromaticImage.PLACEHOLDER)
            .setTitle(PlainComplicationText.Builder(day).build())
            .build()
}