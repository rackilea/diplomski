package com.example.adam.snookerproject;

  import android.content.Intent;
  import android.support.v7.app.AppCompatActivity;
  import android.os.Bundle;
  import android.widget.TextView;

  public class GameLog extends AppCompatActivity {
    private TextView GameLogText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_game_log);

       GameLogText = (TextView) findViewById(R.id.GameLogText);

       //get your log here using AppConstants.log
   }
  }