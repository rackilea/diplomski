package com.androidapps.numberguesser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

int randomNumber;
Random randNum = new Random();

public void randomGenerator(View view) {

    EditText guess = (EditText) findViewById(R.id.guessText);
    String myGuess = guess.getText().toString();

    int guessInt = new Integer(guess.getText().toString());

    if (guessInt == randomNumber) {

        Toast.makeText(getApplicationContext(), "You Guessed The Right Number!!! " + "( " + guessInt + " )" , Toast.LENGTH_LONG).show();
        guess.setText("");
        randomNumber = randNum.nextInt(21);

    } else if (guessInt > randomNumber) {

        Toast.makeText(getApplicationContext(), "Your Guess Is Too High! " + "( " + guessInt + " )", Toast.LENGTH_SHORT).show();
        guess.setText("");


    } else {

        Toast.makeText(getApplicationContext() , "Your Guess Is Too Low! " + "( " + guessInt + " )", Toast.LENGTH_SHORT).show();
        guess.setText("");


    }

}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    randomNumber = randNum.nextInt(21);    
}

}