package com.rudo.calendarhorizontal.data

import android.support.annotation.ColorRes

/**
 * Created by oscarvera on 29/12/17.
 */

data class StyleCalendar( val basicStyle: BasicStyle, var selectedStyle: SelectedStyle?, var daysSelectedStyle: DaysSelectedStyle?)

data class BasicStyle(@ColorRes val colorDaysBefore : Int, @ColorRes val colorDaysAfter : Int, @ColorRes val colorDayToday : Int )

data class SelectedStyle(@ColorRes val colorRange : Int)

data class DaysSelectedStyle(@ColorRes val colorDot : Int)