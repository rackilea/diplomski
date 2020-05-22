for (int c = 0; c < guessedLetters.toCharArray().length(); c++) 
{ // for each guessed letter
    for(int c1 =0; c1<wordToBeFound.toCharArray().length; c1++){  //look at each letter in the word, searching for a match
       if(guessedLetters[c]==hiddenWordChars[c1]){ 
           hiddenWordChars[c1] = guessedLetters[c];      
       }
    }
}