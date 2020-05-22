for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
        buttonID = Integer.toString(++buttonCount);
        //...
        buttons[i][j].setActionCommand(String.toString(buttonID));
        //...
    }
}