package com.dsassignment.sleepscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NightSong extends AppCompatActivity {

    Button sleep;
    Button pause;
    MediaPlayer sleepsong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night_song);

        sleep = findViewById(R.id.sleep);
        pause = findViewById(R.id.pause);
        sleepsong= MediaPlayer.create(NightSong.this,R.raw.song);

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sleepsong == null) {
                    sleepsong = MediaPlayer.create(NightSong.this, R.raw.song);
                    sleepsong.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                        @Override
                        public void onCompletion(MediaPlayer mp){
                            sleepsong.stop();
                        }
                    });
                }

                sleepsong.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sleepsong!=null){
                    sleepsong.release();
                    sleepsong = null;
                    //alarm message
                }
            }
        });
    }
}