package com.rudo.horizontalcalendar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rudo.calendarhorizontal.HorizontalCalendar
import com.rudo.calendarhorizontal.data.BasicStyle
import com.rudo.calendarhorizontal.interfaz.OnClickDateCalendar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), OnClickDateCalendar {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        HorizontalCalendar.Build(this,R.id.horizontalview, BasicStyle(R.color.colorPrimary,R.color.colorPrimaryDark,R.color.colorAccent)).rangeMax(1,HorizontalCalendar.TIMEMEASURE.MONTH).daysInScreen(7)
                .onClickDay(this).build()
    }

    override fun onClickDate(date: Date, isInExtraRange: Boolean, isSelected: Boolean) {

    }
}
