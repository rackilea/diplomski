private void disableButtons() {
    compareCoords(); //This method checks if first button clicked is after 2nd one.
    for (int i = startXCoord; i <= endXCoord; i++) {
        for (int j = startYCoord; j <= endYCoord; j++) {
            buttons[i][j].setEnabled(false); //We disable all buttons in between
        }
    }
}