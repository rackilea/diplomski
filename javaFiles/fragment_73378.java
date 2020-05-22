Choice playerChoice
if (event.getSource() == rock){ 
   playerChoice = Choice.rock; 
}

if (playerChoice == Choice.rock)
    if (cpuChoice == Choice.scissors)
        playerWon = true;