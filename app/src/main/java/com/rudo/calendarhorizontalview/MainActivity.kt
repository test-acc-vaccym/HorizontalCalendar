package com.rudo.calendarhorizontalview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import com.rudo.calendarhorizontal.HorizontalCalendar
import com.rudo.calendarhorizontal.data.BasicStyle
import com.rudo.calendarhorizontal.interfaz.OnClickDateCalendar
import java.util.*

class MainActivity : AppCompatActivity(), OnClickDateCalendar {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var end = Calendar.getInstance()
        end.add(Calendar.DAY_OF_WEEK,2)

        var listdays = arrayListOf<Date>()
        listdays.add(Calendar.getInstance().time)
        var datother = Calendar.getInstance()
        datother.add(Calendar.DAY_OF_MONTH, 2)
        listdays.add(datother.time)

        HorizontalCalendar.Build(this,R.id.calendar_view, BasicStyle(R.color.colorPrimaryDark,R.color.colorPrimary,R.color.colorAccent))
                .rangeMax(1,HorizontalCalendar.TIMEMEASURE.MONTH)
                .periodSelected(Calendar.getInstance().time,end.time,R.color.colorRed)
                .selectedDays(listdays, R.color.colorBlue)
                .daysInScreen(7)
                .onClickDay(this).build()

    }

    override fun onClickDate(date: Date, isInExtraRange: Boolean, isSelected: Boolean) {
        Log.d("prueba","Fecha: ${date.time} ExtraRange: $isInExtraRange , Selected: $isSelected")
    }
}
