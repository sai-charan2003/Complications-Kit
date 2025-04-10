package com.charan.complicationskit.complication

import androidx.wear.watchface.complications.data.ComplicationData
import androidx.wear.watchface.complications.data.ComplicationType
import androidx.wear.watchface.complications.data.PlainComplicationText
import androidx.wear.watchface.complications.data.RangedValueComplicationData
import androidx.wear.watchface.complications.datasource.ComplicationRequest
import androidx.wear.watchface.complications.datasource.SuspendingComplicationDataSourceService
import com.charan.complicationskit.utils.DateUtils

class YearProgressComplicationService : SuspendingComplicationDataSourceService() {
    override suspend fun onComplicationRequest(request: ComplicationRequest): ComplicationData? {
        return createComplication(
            year = DateUtils.getCurrentYear(),
            currentValue = DateUtils.getYearProgress(),
            maxValue = DateUtils.getMaxDaysInYear().toFloat(),
            minValue = 0f
        )

    }

    override fun getPreviewData(type: ComplicationType): ComplicationData? {
        return createComplication(
            year = DateUtils.getCurrentYear(),
            currentValue = DateUtils.getYearProgress(),
            maxValue = DateUtils.getMaxDaysInYear().toFloat(),
            minValue = 0f
        )
    }

    private fun createComplication(
        year : String,
        minValue: Float,
        maxValue: Float,
        currentValue: Float
    ) =
        RangedValueComplicationData.Builder(
            value = currentValue,
            min = minValue,
            max = maxValue,
            contentDescription = PlainComplicationText.Builder("year").build())
            .setText(PlainComplicationText.Builder(year).build())
            .build()

}