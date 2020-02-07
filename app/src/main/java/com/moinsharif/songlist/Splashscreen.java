package com.moinsharif.songlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splashscreen extends AppCompatActivity {

    ProgressBar progressBar;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();

        progressBar = findViewById(R.id.progressbarid);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                do_work();
                start_app();
            }
        });
        thread.start();
    }

    void do_work()
    {
        for(progress = 25 ; progress<=100 ; progress+=25) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);  // define progress bar value
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void start_app()
    {
        Intent intent = new Intent(Splashscreen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
