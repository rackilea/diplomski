public void guess(View view){
    Log.i("Button clicked", "Worked!");

    int guessValue;
    if(!editTextGuess.getText().toString().equals("")){
        guessValue = Integer.parseInt(editTextGuess.getText().toString());
        Log.i("Entered Value:", Integer.toString(guessValue));
        Log.i("The random number is:", Integer.toString(RandomNumber));


        String message;

        if(guessValue > RandomNumber){
            message = "Your guessed number is too high!";
        } else if(guessValue < RandomNumber){
            message = "Your guessed number is too low!";
        } else if(guessValue == RandomNumber){
            message = "You were right! Let's play again!";
            generateRandomNumber();
            Log.i("Info", "New random number created");
        } else {
            message = "Something went wrong...";
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }  else {
        Toast.makeText(this, "Oops, your Textfield is empty", Toast.LENGTH_LONG).show();
    }

}