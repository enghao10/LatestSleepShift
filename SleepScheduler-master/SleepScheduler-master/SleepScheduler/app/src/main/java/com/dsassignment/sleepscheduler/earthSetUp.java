package com.dsassignment.sleepscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class earthSetUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_set_up);

        Button startBtn=findViewById(R.id.earthStartButton);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(earthSetUp.this,earthDataEntry.class));
            }
        });

        //to clear internal storage
//        try{
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(getFilesDir()+File.separator+"earth.txt")));
//            bufferedWriter.write("");
//            bufferedWriter.close();
//        }catch(IOException e){
//            Log.d("IOEException",e.getMessage());
//        }


        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(getFilesDir()+File.separator+"earth.txt")));
            Log.d("Does this work?","yes");
            String read;
            StringBuilder builder = new StringBuilder("");

            while((read = bufferedReader.readLine()) != null){
                builder.append(read);
            }
            Log.d("Output", builder.toString());
            bufferedReader.close();
            String temp=builder.toString();
            Log.d("problem",temp);
            if(!temp.isEmpty()){

                try{
                    BufferedReader bufferedReader1 = new BufferedReader(new FileReader(new File(getFilesDir()+File.separator+"earth.txt")));
                    earthDataStored data=new earthDataStored();
                    Log.d("Does this work?","yes");
                    data.setDate(bufferedReader1.readLine());
                    data.setTime(bufferedReader1.readLine());
                    data.setAge(bufferedReader1.readLine());
                    data.setCountryFrom(bufferedReader1.readLine());
                    data.setCountryTo(bufferedReader1.readLine());

                    bufferedReader1.close();
                    Log.d("test",data.toString());
                }catch(IOException e){
                    Log.d("IOException",e.getMessage());
                }
                Intent change=new Intent(earthSetUp.this,earthMainActivity.class);
                startActivity(change);
            }
        }catch(IOException e){
            Log.d("IOException",e.getMessage());
        }
    }
}