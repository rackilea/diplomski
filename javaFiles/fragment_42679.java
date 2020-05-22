for (int ii = 0; ii < randW.length(); ii++) {
    if (guess == randW.charAt(ii)) {
        hiddenW.setCharAt(ii, guess);
        match = true;
    } if(guess != randW.charAt(ii)){//Without this if.
        match = false;
    }//I want it to do this only if the guessed letter is not in the word
} // end 2nd loop