package com.apps.a7pl4y3r.clock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlertReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val notificationHelper = NotificationHelper(context)
        val nb = notificationHelper.getNotification("Title","Message")
        notificationHelper.getManager().notify(1,nb.build())

    }
}