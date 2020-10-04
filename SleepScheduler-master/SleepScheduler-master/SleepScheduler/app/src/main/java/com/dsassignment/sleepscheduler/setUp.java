package com.dsassignment.sleepscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class setUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);

        Button startBttn=findViewById(R.id.startButton);
        final Intent setUp=new Intent(setUp.this, dataEntry.class);
        startBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(setUp);
            }
        });

        //to clear internal storage

//        try{
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(getFilesDir()+File.separator+"MyFile.txt")));
//            bufferedWriter.write("");
//            bufferedWriter.close();
//        }catch(IOException e){
//            Log.d("IOEException",e.getMessage());
//        }

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(getFilesDir()+File.separator+"MyFile.txt")));
            String read;
            StringBuilder builder = new StringBuilder("");

            while((read = bufferedReader.readLine()) != null){
                builder.append(read);
            }
            Log.d("Output", builder.toString());
            bufferedReader.close();
            String temp=builder.toString();

            if(!temp.isEmpty()){

                try{
                    BufferedReader bufferedReader1 = new BufferedReader(new FileReader(new File(getFilesDir()+File.separator+"MyFile.txt")));
                    dataStored data=new dataStored();

                    data.setDate(bufferedReader1.readLine());
                    data.setTime(bufferedReader1.readLine());
                    data.setDateLeaving(bufferedReader1.readLine());
                    data.setAge(Integer.parseInt(bufferedReader1.readLine()));
                    data.setDaysInSpace(Integer.parseInt(bufferedReader1.readLine()));

                    bufferedReader1.close();
                    Log.d("test",data.toString());
                }catch(IOException e){
                    Log.d("IOException",e.getMessage());
                }

                Intent change=new Intent(setUp.this,MainActivity.class);
                startActivity(change);
            }
        }catch(IOException e){
            Log.d("IOException",e.getMessage());
        }
    }
}