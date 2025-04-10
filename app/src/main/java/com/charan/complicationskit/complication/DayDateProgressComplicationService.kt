package com.charan.complicationskit.complication

import android.util.Log
import androidx.wear.watchface.complications.data.ComplicationData
import androidx.wear.watchface.complications.data.ComplicationType
import androidx.wear.watchface.complications.data.PlainComplicationText
import androidx.wear.watchface.complications.data.RangedValueComplicationData
import androidx.wear.watchface.complications.data.ShortTextComplicationData
import androidx.wear.watchface.complications.datasource.ComplicationRequest
import androidx.wear.watchface.complications.datasource.SuspendingComplicationDataSourceService
import com.charan.complicationskit.utils.Constants.TOTAL_MIN_IN_DAY
import com.charan.complicationskit.utils.DateUtils
import kotlin.math.min

class DayDateProgressComplicationService : SuspendingComplicationDataSourceService(){
    override suspend fun onComplicationRequest(request: ComplicationRequest): ComplicationData? {
        return createComplication(
            day = DateUtils.getCurrentDay(),
            date = DateUtils.getMonthAndDay(),
            currentValue = DateUtils.getDayProgress(),
            maxValue = TOTAL_MIN_IN_DAY.toFloat(),
            minValue = 0f
        )

    }

    override fun getPreviewData(type: ComplicationType): ComplicationData? {
        return createComplication(
            day = DateUtils.getCurrentDay(),
            date = DateUtils.getMonthAndDay(),
            currentValue = DateUtils.getDayProgress(),
            maxValue = TOTAL_MIN_IN_DAY.toFloat(),
            minValue = 0f
        )

    }

    private fun createComplication(day: String, date: String, currentValue : Float, maxValue: Float, minValue: Float) =
        RangedValueComplicationData.Builder(
            value = currentValue,
            min = minValue,
            max = maxValue,
            contentDescription = PlainComplicationText.Builder("date").build()
        )
            .setText(PlainComplicationText.Builder(day).build())
            .setTitle(PlainComplicationText.Builder(date).build())
            .build()






}