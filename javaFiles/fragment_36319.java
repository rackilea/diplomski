ButtonListener buttonListener = new ButtonListener();
  for (int row = 0; row < buttonGrid.length; row++) {
     for (int col = 0; col < buttonGrid[row].length; col++) {
        buttonGrid[row][col] = new JButton(BLANK);
        buttonGrid[row][col].addActionListener(buttonListener);
        // add to GridLayout using JPanel
     }
  }