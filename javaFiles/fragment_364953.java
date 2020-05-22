int number = 0;
for (int i = 0; i < buttons.length; i++){
    for (int j = 0; j < buttons[0].length; j++){  //watch here for additional index [0] in length (it is size of "second dimension")
        buttons[i][j] = new JButton();
        frame.add(buttons[i][j]);
        buttons[i][j].setText("Button" + number);
        number++; //in separate line for clarity
    }
}