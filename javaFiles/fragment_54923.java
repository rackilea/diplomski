package com.example.borntoflirt.design1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdditionActivity extends AppCompatActivity {

    private EditText valueOne;
    private EditText valueTwo;
    private TextView result;
    private Button btnAdd;

    private double num1;
    private double num2;
    private double sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.addition);

    valueOne = (EditText) findViewById(R.id.valueOne);
    valueTwo = (EditText) findViewById(R.id.valueTwo);
    result = (TextView) findViewById(R.id.result);
    btnAdd = (Button) findViewById(R.id.buttonAdd);

    btnAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            num1 = Double.parseDouble(valueOne.getText().toString());
            // result.setText(Double.toString(Double.parseDouble(valueOne.getText().toString()) + Double.parseDouble(valueTwo.getText().toString())));

        }
    });
  }
}