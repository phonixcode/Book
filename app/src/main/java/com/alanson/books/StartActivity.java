package com.alanson.books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {
    private TextView startFeedBackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startFeedBackText = findViewById(R.id.start_feedback);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startFeedBackText.setText("loading...");
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        },3000);
    }
}