if(inputChars[i] == 'X') {               // VALID
        if(inputChars[i+1] == '-') {     // INVALID
            points += 0;
        } else if (inputChars[i+1]== '/') {  // INVALID
            points += 10;
        } else {
            points += Character.getNumericValue(inputChars[i+1]); // INVALID
        }
        if(inputChars[i+2] == '-') { // INVALID