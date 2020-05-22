package com.example.anagramslayer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Story1 extends Activity implements OnClickListener{

    private String x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        x = "hello";

    }

    @Override
    public void onClick(View v) {
         switch(v.getId()){

         }
}