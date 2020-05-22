boolean finished = false;
while (!finished) {
//     ↑ ↑ ↑ ↑ ↑ →→→→→→ this means loop while finished == false 
    randomNumber1 = random.nextInt(size);
    randomNumber2 = random.nextInt(size);
    if (puzzlePanel.arrayOfButtons[randomNumber1][randomNumber2].getText().isEmpty()) {
        puzzlePanel.arrayOfButtons[randomNumber1][randomNumber2].setText(puzzle.getSingleLetter(randomNumber1, randomNumber2) + "");
        finished = true;
     }    
 }