package com.dsassignment.sleepscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page);

        Button spaceBttn=findViewById(R.id.spaceButton);
        Button earthBttn=findViewById(R.id.earthButton);

        spaceBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(startingPage.this,setUp.class));
            }
        });

        earthBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(startingPage.this,earthSetUp.class));
            }
        });
    }
}