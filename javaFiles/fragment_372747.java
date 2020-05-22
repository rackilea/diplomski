private ActionListener listener = e -> {
    //Loops through the whole array in both dimensions
    for (int i = 0; i < buttons.length; i++) {
        for (int j = 0; j < buttons[i].length; j++) {
            if (e.getSource().equals(buttons[i][j])) { //Find the JButton that was clicked
                if (isStartButton) { //startButton is a boolean variable that tells us if this is the first button clicked or not
                    startXCoord = i;
                    startYCoord = j;
                } else {
                    endXCoord = i;
                    endYCoord = j;
                    disableButtons(); //Only when we have clicked twice we disable all the buttons in between
                }
                isStartButton = !isStartButton; //In every button click we change the value of this variable
                break; //No need to keep looking if we found our clicked button. Add another one with a condition to skip the outer loop.
            }
        }
    }
};