Boolean flag = false;
for (int i = 0; i < randomWordToGuess.length; i++) {
    if (randomWordToGuess[i] == input) {
       playerGuess[i] = input;
       flag = true; //user input is correct
       break;
    }
}

if (!flag){ //user input is wrong
   attempt--;
}