package com.example.datechanger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Year;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private String strDatei;
    private String strDates;
    int years,months,days;
    private Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Taking the date By DatePicker
        ImageButton pickDate=(ImageButton)findViewById(R.id.date_piker);
        TextView in_date=(TextView)findViewById(R.id.input_date);

        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        years=year;
                        months=month+1;
                        days=dayOfMonth;
                        strDatei=years+"/"+months+"/"+days;
                        in_date.setText(strDatei);
                    }
                },years,months,days);

                dialog.show();
            }
        }); //end of taking date by DatePicker

        //Taking yesterday date by yesterday button
        Button yesterday = (Button)findViewById(R.id.yesterday);

        yesterday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar=Calendar.getInstance();
                years=calendar.get(Calendar.YEAR);
                months=calendar.get(Calendar.MONTH)+1;
                days=(calendar.get(Calendar.DAY_OF_MONTH))-1;
                if(days==1){
                    if( months==1)
                    {
                        days=29;
                        months=12;
                        years=years-1;
                    }
                    else if(months>1&&months<=7)
                    {
                        days=31;
                        months=months-1;
                    }
                    else if(months>7&&months<=12)
                    {
                        days=30;
                        months=months-1;
                    }
                }
                else if(days==0){
                    if( months==1)
                    {
                        days=29;
                        months=12;
                        years=years-1;
                    }
                    else if(months>1&&months<=7)
                    {
                        days=31;
                        months=months-1;
                    }
                    else if(months>7&&months<=12)
                    {
                        days=30;
                        months=months-1;
                    }
                }
                strDatei=years+"/"+months+"/"+days;
                in_date.setText(strDatei);
            }
        });
        //Taking today date by Today button
        Button today = (Button)findViewById(R.id.today);

        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                calendar=Calendar.getInstance();
                years=calendar.get(Calendar.YEAR);
                months=calendar.get(Calendar.MONTH)+1;
                days=calendar.get(Calendar.DAY_OF_MONTH);
                strDatei=years+"/"+months+"/"+days;
                in_date.setText(strDatei);
            }
        });//end of Taking date by Today Button

        //Taking tomorrow date by tomorrow button
        Button tomorrow = (Button)findViewById(R.id.tomorrow);

        tomorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar=Calendar.getInstance();
                years=calendar.get(Calendar.YEAR);
                months=calendar.get(Calendar.MONTH)+1;
                days=calendar.get(Calendar.DAY_OF_MONTH);

                if(days==31)
                {
                    if(months>=1&&months<=6){
                        days=1;
                        months=months+1;
                    }
                    else if(months>=7&&months<12){
                        days=1;
                        months=months+1;
                    }
                    else if(months==12){
                        days=1;
                        months=1;
                        years=years+1;
                    }
                }
                else if(days==30)
                {
                    if(months>=1&&months<=6){
                        days=1;
                        months=months+1;
                    }
                    else if(months>=7&&months<12){
                        days=1;
                        months=months+1;
                    }
                    else if(months==12){
                        days=1;
                        months=1;
                        years=years+1;
                    }
                }
                else if(days==29)
                {
                    if(months>=1&&months<=6){
                        days=1;
                        months=months+1;
                    }
                    else if(months>=7&&months<12){
                        days=1;
                        months=months+1;
                    }
                    else if(months==12){
                        days=1;
                        months=1;
                        years=years+1;
                    }
                }
                else {
                    days=days+1;
                }

//
//                if(days==31&&months>=1&&months<=6)
//                {
//                    Toast.makeText(MainActivity.this,"if(days==31&&months>=1&&months<=6) executed!",Toast.LENGTH_SHORT).show();
//                    days=1;
//                    months=months+1;
//                }
//                else if(days==30&&months>=7&&months<12){
//                    days=1;
//                    months=months+1;
//                }
//                else if(days==29&&months==12){
//                    days=1;
//                    months=1;
//                    years=years+1;
//                }
//                else if(days==29||days==30||days==31)
                strDatei=years+"/"+months+"/"+days;
                in_date.setText(strDatei);
            }
        });


    }



}