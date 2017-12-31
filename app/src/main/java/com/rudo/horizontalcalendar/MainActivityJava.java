package com.rudo.horizontalcalendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rudo.calendarhorizontal.HorizontalCalendar;
import com.rudo.calendarhorizontal.data.BasicStyle;
import com.rudo.calendarhorizontal.interfaz.OnClickDateCalendar;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

/**
 * Created by oscarvera on 31/12/17.
 */

public class MainActivityJava extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        new HorizontalCalendar.Build(this, R.id.horizontalview,new BasicStyle(R.color.colorPrimary,R.color.colorPrimaryDark,R.color.colorAccent)).onClickDay(new OnClickDateCalendar() {
            @Override
            public void onClickDate(@NotNull Date date, boolean isInExtraRange, boolean isSelected) {

            }
        }).build();


    }
}
