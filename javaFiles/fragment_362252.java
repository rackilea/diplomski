package com.ultraman11.timertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public int numCounter = 0;
    public boolean counting = false;

    TextView counter;
    TextView difference;
    EditText numInput;

    public int userInt
    public int differenceInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = (TextView) findViewById(R.id.counter);
        difference = (TextView) findViewById(R.id.diff);
        numInput = (EditText) findViewById(R.id.numInput);

        try{
          userInt = Integer.parseInt(numInput.getText().toString());
        }Catch(Exception e){
          userInt = 0;
        }            
        differenceInt = Math.abs(numCounter - userInt);
    }

    public void resetButton(View v){
        numCounter = 0;
        difference.setText("Difference: ");
        counter.setText(Integer.toString(0));
    }

    public void startButton(View v){
        counting = true;
        while(counting){
            numCounter++;
        }
    }

    public void stopButton(View v){
        counting = false;
        difference.setText("Difference: " + Integer.toString(differenceInt));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}