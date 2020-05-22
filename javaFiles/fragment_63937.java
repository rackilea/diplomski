void draw() { 

    for (int i = 0; i < cols; i++) {
        for (int j = 0; j < rows; j++) {

            if (boxes[i][j].light == true) {
                 boxes[i][j].rollover(mouseX, mouseY);
                 boxes[i][j].displayOn();
            } else {
                 boxes[i][j].displayOff();
            }
        }
    }
}