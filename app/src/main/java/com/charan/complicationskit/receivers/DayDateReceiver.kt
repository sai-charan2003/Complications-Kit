package com.charan.complicationskit.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.charan.complicationskit.complication.DayDateComplicationService
import com.charan.complicationskit.complication.DayDateProgressComplicationService
import com.charan.complicationskit.complication.YearProgressComplicationService
import com.charan.complicationskit.utils.ComplicationUtils
import com.charan.complicationskit.utils.Constants

class DayDateReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        if(context == null || intent == null) return
        if(intent.action  in Constants.TIME_CHANGE_INTENT_ACTIONS){
            ComplicationUtils.updateComplication(context, DayDateComplicationService::class.java)
            ComplicationUtils.updateComplication(context, DayDateProgressComplicationService::class.java)
            ComplicationUtils.updateComplication(context, YearProgressComplicationService::class.java)
        }

    }

}