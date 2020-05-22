package com.example.don.myapp;

import android.widget.EditText;

public class Simplejava {

public void MainStart(Activity activity)
{
    System.out.println("Hello");

    EditText changetext = (EditText) activity.findViewById(R.id.editText1);
    changetext.setText("Hello");
}
}