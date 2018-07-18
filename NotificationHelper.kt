package com.apps.a7pl4y3r.clock

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.support.v4.app.NotificationCompat

class NotificationHelper(base: Context?) : ContextWrapper(base) {

    private val mainChannelId = "mainChannel"
    private val mainChannelName = "main"
    var mManager: NotificationManager? = null

    fun createChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(mainChannelId, mainChannelName,
                    NotificationManager.IMPORTANCE_DEFAULT)

            getManager().createNotificationChannel(channel)

        }
    }

    fun getManager(): NotificationManager{

        if(mManager == null){
            mManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }

        return mManager as NotificationManager
    }

    fun getNotification(title: String, message: String):NotificationCompat.Builder{

        return NotificationCompat.Builder(applicationContext,mainChannelId)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_android_black_24dp)

    }

}