try {
        number = Integer.parseInt(temp);
        if (x < number)
            prompt.setText("Too high. Try again.");
        else if (x > number)
            prompt.setText("Too low. Try again.");
        else if (x == number)
            prompt.setText("Found it!");
        else
            prompt.setText("Invalid or not a number. Choose a number between 1 and 100");
 } catch(java.lang.NumberFormatException e) {
        prompt.setText("That is not a number!");
 }
 return(true);