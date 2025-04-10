package com.charan.complicationskit.utils

import android.content.Intent

object Constants {
    val TIME_CHANGE_INTENT_ACTIONS = listOf(
        Intent.ACTION_TIME_CHANGED,
        Intent.ACTION_TIMEZONE_CHANGED,
        Intent.ACTION_DATE_CHANGED
    )
    val TOTAL_MIN_IN_DAY = 1440

}
