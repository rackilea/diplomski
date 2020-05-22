package com.example.dummy_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);

        if (textView.getText().toString().equals("Happy Birthday!")) {
            Log.d("logMessage", "correct message shown");
        } else {
            Log.e("logMessage", "exception error");
        }
    }
}