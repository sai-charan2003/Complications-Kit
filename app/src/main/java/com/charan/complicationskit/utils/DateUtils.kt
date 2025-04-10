package com.charan.complicationskit.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object DateUtils {
    fun getCurrentDay(): String{
        return when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            Calendar.SUNDAY -> "Sun"
            Calendar.MONDAY -> "Mon"
            Calendar.TUESDAY -> "Tue"
            Calendar.WEDNESDAY -> "Wed"
            Calendar.THURSDAY -> "Thu"
            Calendar.FRIDAY -> "Fri"
            Calendar.SATURDAY -> "Sat"
            else -> throw IllegalArgumentException("too many days")
        }
    }

    /**
     * This will return date in MM DD format
     */
    fun getMonthAndDay(): String {
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())
        return "$month $day"
    }

    /**
     * This will return day progress in float
     */


    fun getDayProgress() : Float {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        return (hour * 60 + minute).toFloat()
    }

    /**
     * This will return year progress in float
     */

    fun getYearProgress() : Float {
        val calender = Calendar.getInstance()
        val day = calender.get(Calendar.DAY_OF_YEAR)
        return day.toFloat()
    }

    /**
     * This will return month progress in float
     */
    fun getMonthProgress() : Float {
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return day.toFloat()
    }

    /**
     * This will return current year
     */
    fun getCurrentYear() : String{
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.YEAR).toString()

    }

    /**
     * This will return what is the max days in a year
     */

    fun getMaxDaysInYear() : Float {
        val calendar = Calendar.getInstance()
        return calendar.getActualMaximum(Calendar.DAY_OF_YEAR).toFloat()

    }
}