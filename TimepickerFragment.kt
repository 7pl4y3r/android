package com.apps.a7pl4y3r.clock

import android.app.Dialog
import android.app.DialogFragment
import android.app.TimePickerDialog
import android.os.Bundle
import java.util.*

class TimepickerFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        return TimePickerDialog(activity, activity as TimePickerDialog.OnTimeSetListener, hour, minute, true)
    }
}