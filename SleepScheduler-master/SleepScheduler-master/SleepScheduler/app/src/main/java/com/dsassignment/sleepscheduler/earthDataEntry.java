package com.dsassignment.sleepscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class earthDataEntry extends AppCompatActivity {
private EditText date,time,age;
private Spinner countryFrom,countryTo;
private Button submitButton;
private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_data_entry);

        age=findViewById(R.id.ageInput);
        date=findViewById(R.id.dateArrival);
        time=findViewById(R.id.timeInput);
        countryFrom=findViewById(R.id.countryFrom);
        countryTo=findViewById(R.id.countryTo);
        submitButton=findViewById(R.id.earthSubmitButton);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(earthDataEntry.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(earthDataEntry.this,
                        new TimePickerDialog.OnTimeSetListener(){
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                time.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }

    public void submit(){
        String dateIn=date.getText().toString();
        String timeIn=time.getText().toString();
        String ageIn=age.getText().toString();
        String countryFromIn=countryFrom.getSelectedItem().toString();
        String countryToIn=countryTo.getSelectedItem().toString();

        if(TextUtils.isEmpty(dateIn)){
            date.setError("Required to be filled in");
            date.requestFocus();
        }else if(TextUtils.isEmpty(timeIn)){
            time.setError("Required to be filled in");
            time.requestFocus();
        }else if(TextUtils.isEmpty(ageIn)){
            age.setError("Required to be filled in");
            age.requestFocus();
        }else{

            try{
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(getFilesDir()+File.separator+"earth.txt")));
                bufferedWriter.write(dateIn);
                bufferedWriter.newLine();
                bufferedWriter.write(timeIn);
                bufferedWriter.newLine();
                bufferedWriter.write(ageIn);
                bufferedWriter.newLine();
                bufferedWriter.write(countryFromIn);
                bufferedWriter.newLine();
                bufferedWriter.write(countryToIn);
                bufferedWriter.newLine();
                Log.d("Success","data entered");
                bufferedWriter.close();
            }catch(IOException e){
                Log.d("IOException", e.getMessage());
            }

            earthDataStored earthData=new earthDataStored();
            earthData.setDate(dateIn);
            earthData.setTime(timeIn);
            earthData.setAge(ageIn);
            earthData.setCountryFrom(countryFromIn);
            earthData.setCountryTo(countryToIn);
            Log.d("success",earthData.toString());

            startActivity(new Intent(earthDataEntry.this, earthMainActivity.class));
        }
    }

//    private AdapterView.OnItemSelectedListener OnCatSpinnerCL = new AdapterView.OnItemSelectedListener() {
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//            ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
//            ((TextView) parent.getChildAt(0)).setTextSize(5);
//
//        }
//
//        public void onNothingSelected(AdapterView<?> parent) {
//
//        }
//    };
}