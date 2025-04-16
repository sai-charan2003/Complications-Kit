package com.charan.complicationskit.complication

import androidx.wear.watchface.complications.data.ComplicationData
import androidx.wear.watchface.complications.data.ComplicationType
import androidx.wear.watchface.complications.data.PlainComplicationText
import androidx.wear.watchface.complications.data.RangedValueComplicationData
import androidx.wear.watchface.complications.datasource.ComplicationRequest
import androidx.wear.watchface.complications.datasource.SuspendingComplicationDataSourceService
import com.charan.complicationskit.utils.ComplicationUtils
import com.charan.complicationskit.utils.DateUtils

class MonthProgressComplicationService : SuspendingComplicationDataSourceService() {
    override suspend fun onComplicationRequest(request: ComplicationRequest): ComplicationData? {
        return createComplication(
            month = DateUtils.getCurrentMonth(),
            currentValue = DateUtils.getMonthProgress(),
            maxValue = DateUtils.getMaxCurrentMonthDays(),
            minValue = 0f
        )

    }

    override fun getPreviewData(type: ComplicationType): ComplicationData? {
        return createComplication(
            month = DateUtils.getCurrentMonth(),
            currentValue = DateUtils.getMonthProgress(),
            maxValue = 12f,
            minValue = 0f
        )

    }

    private fun createComplication(
        month : String,
        minValue: Float,
        maxValue: Float,
        currentValue: Float
    ) =
        RangedValueComplicationData.Builder(
            value = currentValue,
            min = minValue,
            max = maxValue,
            contentDescription = PlainComplicationText.Builder("Month").build())
            .setText(PlainComplicationText.Builder(month).build())
            .setTapAction(ComplicationUtils.openCalender(this))
            .build()



}