hintWord = "";
for (int i = 0; i < secretWord.length(); i++){ 
    if (secretWord.charAt(i) == guess){  //Check if we found anything
        //found = true; We do not need this variable since we already know if we found something 
        correctLetters[i] = guess;
    }
    hintWord += correctLetters[i];
}