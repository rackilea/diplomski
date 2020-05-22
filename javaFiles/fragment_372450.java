for (int counter = 0; counter < possibleAnswers.length; counter++){
    // This condition will be meet immediately because 0 is less then 25...
    if (counter < 25){
        return alpha[counter] + ": " + possibleAnswers[counter] + "\n";
    }
    // Meaning it is impossible for the program to ever reach this line...
    if (counter >= 26){
        return alpha[26] + a + ": " + possibleAnswers[counter] + "\n";
        a++;
    }
}