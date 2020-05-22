package com.example.activitydatasend;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Second extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Bundle bundle = getIntent().getExtras();
        String a = bundle.getString("first");
        String b = bundle.getString("second");
        System.out.println(a+b);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}