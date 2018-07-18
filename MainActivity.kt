package com.apps.a7pl4y3r.clock

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(),TimePickerDialog.OnTimeSetListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSetAlarm.setOnClickListener({

            val timePicker = TimepickerFragment()
            timePicker.show(fragmentManager,"Time picker")

        })

    }

    override fun onTimeSet(p0: TimePicker?, hour: Int, minute: Int) {
        tvSelectedTime.text = ("$hour:$minute")

        val c = Calendar.getInstance()
        c.set(Calendar.HOUR_OF_DAY,hour)
        c.set(Calendar.MINUTE,minute)
        c.set(Calendar.SECOND,0)

        startAlarm(c)

    }

    private fun startAlarm(c: Calendar){

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this,AlertReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this,1,intent,0)

        alarmManager.setExact(AlarmManager.RTC_WAKEUP,c.timeInMillis,pendingIntent)

    }

    private fun cancelAlarm(){}

}
