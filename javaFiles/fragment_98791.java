package com.psegina.passwordTest01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {
    LinearLayout l;
    EditText user;
    EditText pwd;
    Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        l = new LinearLayout(this);
        user = new EditText(this);
        pwd = new EditText(this);
        btn = new Button(this);

        l.addView(user);
        l.addView(pwd);
        l.addView(btn);
        btn.setOnClickListener(this);

        setContentView(l);
    }

    public void onClick(View v){
        String u = user.getText().toString();
        String p = pwd.getText().toString();
        if( u.equals( p ) )
            Toast.makeText(getApplicationContext(), "Matches", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), user.getText()+" != "+pwd.getText(), Toast.LENGTH_SHORT).show();
    }
}