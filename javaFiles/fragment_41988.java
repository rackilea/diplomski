EditText playerOne = (EditText) findViewById(R.id.player1);
EditText playerTwo = findViewById(R.id.player2);
Button button = findViewById(R.id.button); //Make sure you define this is your xml file with the id button

button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String player1 = playerOne.getText().toString();
            String player2 = playerTwo.getText().toString();
            //Set your toast here
        }
    });