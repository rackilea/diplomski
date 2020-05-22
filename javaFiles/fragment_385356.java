package com.kurdfoxx.nightmodewithsharedprefrense;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String DARKMODE = "dark";
    boolean isDarkMode ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getData();
        Toast.makeText(this, "is datk ?"+isDarkMode, Toast.LENGTH_SHORT).show();

        if (isDarkMode){
                setTheme(R.style.darkTheme);
        }else {setTheme(R.style.AppTheme);}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button_go_to_setting_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SettingActivity.class));
            }
        });

    }
    private void getData() {

        SharedPreferences sharedPreferences = getSharedPreferences(DARKMODE, MODE_PRIVATE);
        isDarkMode = sharedPreferences.getBoolean("ISDARKMODE", false);



    }




}