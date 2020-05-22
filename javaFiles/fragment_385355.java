package com.kurdfoxx.nightmodewithsharedprefrense;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {
   public static Switch mySwitch;
    boolean isDarkMode =false;
    private static final String DARKMODE = "dark";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme);
            isDarkMode=true;

        } else {
            setTheme(R.style.AppTheme);
            isDarkMode=false;


        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toast.makeText(this, ""+ isDarkMode, Toast.LENGTH_SHORT).show();
        mySwitch = findViewById(R.id.switch1);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            mySwitch.setChecked(true);
        }
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    isDarkMode=true;
                    myboolian();


                    restartApp();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    isDarkMode=false;
                    myboolian();

                    restartApp();

                }
            }
        });
        myboolian();

        Button buttonGoMain=findViewById(R.id.btn_go_MainAct);
        buttonGoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this,MainActivity.class));

            }
        });


    }

    public void restartApp() {
        Intent intentRestartApp = new Intent(getApplicationContext(), SettingActivity.class);
        startActivity(intentRestartApp);
        finish();

    }
    public void myboolian(){
     // isDarkMode =!isDarkMode;  //change isDarkMode from false to true by this
        SharedPreferences sharedPreferences =getSharedPreferences(DARKMODE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("ISDARKMODE", isDarkMode);
        editor.apply();


    }


}