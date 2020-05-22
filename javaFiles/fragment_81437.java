package com.example.userinput;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


      private ArrayList<String> searchNames = new ArrayList<String>();
      EditText nameCaptureNo;
      EditText nameCaptureUz;
      Button send;
      TextView tvTi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameCaptureNo = (EditText) findViewById(R.id.nameCaptureNo);
        nameCaptureUz = (EditText) findViewById(R.id.nameCaptureUz);




        nameCaptureNo.addTextChangedListener(new TextWatcher()
        {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                    int after) {
                Log.d("MainActivity", "Text Modified "+ nameCaptureNo.getText().toString());

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                    int count) {

                Log.d("MainActivity", "Text Modified "+ nameCaptureNo.getText().toString());
                if(checkString(nameCaptureNo.getText().toString()))
                {
                    send.setVisibility(View.VISIBLE);
                }
                else
                {
                    send.setVisibility(View.INVISIBLE);
                    //warning                   
                    tvTi.setText("Izvēlies pilsētu no saraksta!");
                    tvTi.setTextColor(Color.RED);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

                Log.d("MainActivity", "Text Modified "+ nameCaptureNo.getText().toString());

            }

        });

        send = (Button) findViewById(R.id.send);

        //Set the send button invisible 
        send.setVisibility(View.INVISIBLE);

        tvTi = (TextView) findViewById(R.id.tvTi);


        searchNames.add("Test1");
        searchNames.add("Test2");
        searchNames.add("Test3");
        searchNames.add("Test4");
        searchNames.add("Test5");
        searchNames.add("Test6");
    }

    public boolean checkString(String value)
    {
        boolean found = false;

        for(String searchcontent:searchNames)
        {
            if((searchcontent).equalsIgnoreCase(value))
            {
                found = true;
                break;
            }

        }


        return found;
    }
}