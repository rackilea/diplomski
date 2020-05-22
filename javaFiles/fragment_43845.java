[...]

    leftNumber.setImageResource(numberArray[0]);
    rightNumber.setImageResource(numberArray[0]);

     // Create a random number generator
     Random randomNumberGenerator = new Random();

     int value1 = randomNumberGenerator.nextInt(10);

     leftNumber.setImageResource(numberArray[value1]);

     // Create a new random number
     int value2 = randomNumberGenerator.nextInt(10);

     // Set the right dice image using an image from the diceArray.
     rightNumber.setImageResource(numberArray[value2]);
     answer_field = findViewById(R.id.answer_field);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              answer = valueOf(answer_field.getText().toString());
                value3 = value1 * value2;
                if(value3 == answer) {
                    showToast("Correct");
                }
            }
        });

[...]