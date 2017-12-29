package com.rudo.calendarhorizontal.adapter

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.rudo.calendarhorizontal.R
import com.rudo.calendarhorizontal.entity.Day
import com.rudo.calendarhorizontal.inflate
import kotlinx.android.synthetic.main.item_calendar_day.view.*
import java.util.*
import android.graphics.drawable.GradientDrawable
import com.rudo.calendarhorizontal.data.BasicStyle
import com.rudo.calendarhorizontal.data.StyleCalendar
import com.rudo.calendarhorizontal.interfaz.OnClickDateCalendar
import com.rudo.calendarhorizontal.isSameDay


/**
 * Created by oscarvera on 28/12/17.
 */
class CalendarAdapter (var days : ArrayList<Day>, var width : Int, style: StyleCalendar, var listener : OnClickDateCalendar?)  : RecyclerView.Adapter<CalendarAdapter.ViewHolderDay>() {

    val styleBasic = style

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarAdapter.ViewHolderDay = ViewHolderDay(parent.inflate(R.layout.item_calendar_day), styleBasic, listener)


    override fun onBindViewHolder(holder: CalendarAdapter.ViewHolderDay, position: Int) = holder.bind(days[position],width)


    override fun getItemCount(): Int = days.size


    class ViewHolderDay(itemView: View, style: StyleCalendar, listener : OnClickDateCalendar?) : RecyclerView.ViewHolder(itemView) {

        val style = style
        val listener = listener

        fun bind(day : Day ,width: Int) = with(itemView) {
            itemView.minimumWidth = width

            var calendar = Calendar.getInstance()
            calendar.time = day.date

            val dayofweek = calendar[Calendar.DAY_OF_WEEK]
            txtDay.text = LETTERDAY.values()[dayofweek-1].toString()

            txtNumDay.text = calendar.get(Calendar.DAY_OF_MONTH).toString()


            when {
                calendar.isSameDay(Calendar.getInstance()) -> { //Comprueba si es el mismo dia
                    val bgShape = txtNumDay.background as GradientDrawable
                    bgShape.setColor(ContextCompat.getColor(context,style.basicStyle.colorDayToday))
                }
                day.isDone -> { //Comprueba si es un dia pasado
                    val bgShape = txtNumDay.background as GradientDrawable
                    bgShape.setColor(ContextCompat.getColor(context,style.basicStyle.colorDaysBefore))
                }
                else -> { //El dia es futuro
                    val bgShape = txtNumDay.background as GradientDrawable
                    bgShape.setColor(ContextCompat.getColor(context,style.basicStyle.colorDaysAfter))
                }
            }

            if (day.isSelected){
                viewSelected.visibility = View.VISIBLE
                style.daysSelectedStyle?.let{
                    val bgShape = viewSelected.background as GradientDrawable
                    bgShape.setColor(ContextCompat.getColor(context,it.colorDot))
                }
            }else{
                viewSelected.visibility = View.INVISIBLE
            }

            if (day.isExtraRange){
                style.selectedStyle?.let {
                    val bgShape = txtNumDay.background as GradientDrawable
                    bgShape.setColor(ContextCompat.getColor(context,it.colorRange))
                }

            }


            itemDay.setOnClickListener {
                listener?.let {
                    it.onClickDate(day.date,day.isExtraRange,day.isSelected)
                }

            }

        }
    }

    enum class LETTERDAY{
        D,L,M,X,J,V,S
    }
}

