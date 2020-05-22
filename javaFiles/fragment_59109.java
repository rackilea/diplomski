package com.me.addcontact

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

SharedPreferences sharedPreferences;

SharedPreferences.Editor editor;


@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    sharedPreferences = this.getSharedPreferences("com.me.addcontact", Context.MODE_PRIVATE);


    Button btn1= (Button) findViewById(R.id.button1);

    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            EditText name1 = (EditText)findViewById(R.id.name1);
            EditText num1 = (EditText)findViewById(R.id.num1);

            EditText name2 = (EditText)findViewById(R.id.name2);
            EditText num2 = (EditText)findViewById(R.id.num2);

            EditText name3 = (EditText)findViewById(R.id.name3);
            EditText num3 = (EditText)findViewById(R.id.num3);

            editor = sharedPreferences.edit();
            editor.putString("name1", name1.getText().toString());
            editor.putInt("num1", Integer.parseInt(num1.getText().toString()));
            editor.putString("name2", name2.getText().toString());
            editor.putInt("num2", Integer.parseInt(num2.getText().toString()));
            editor.putString("name3", name3.getText().toString());
            editor.putInt("num3", Integer.parseInt(num3.getText().toString()));

            editor.commit();
            Toast.makeText(getApplicationContext(), "Details Saved", Toast.LENGTH_SHORT).show();
        }
    });

}