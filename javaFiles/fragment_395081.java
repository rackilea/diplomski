package com.example;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import java.util.ArrayList<E>;

public class FOREVERAPHONE extends Activity {
    int selector;
    Button add, sub;
    TextView display;
    // List of random quotes
    ArrayList<String> listOfRandomQuotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreveraphone);

        listOfRandomQuotes = new ArrayList<String>();
        listOfRandomQuotes.add("A penny saved is a penny earned.");
        listOfRandomQuotes.add("You must be the change you wish to see in the world.");
        listOfRandomQuotes.add("I have decided to stick with love. Hate is too great a burden to bear.");
        listOfRandomQuotes.add("By failing to prepare, you are preparing to fail.");

        add = (Button) findViewById(R.id.bAdd);
        sub = (Button) findViewById(R.id.bSub);
        display = (TextView) findViewById(R.id.tvDisplay);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Random randomNumber = new Random();
                selector = randomNumber.nexInt(4);
                display.setText(listOfRandomQuotes.get(selector));
            }
        });
    }

}