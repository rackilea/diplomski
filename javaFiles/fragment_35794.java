for(int i = 0; i<9; i++){
    for(int j = 0; j<9; j++){
      String appropriateNumber = convertSimple(grid2[i][j]);
      someButtonArray[i][j].setText(appropriateNumber);

      // no longer need this stuff
      // JButton button = new JButton(appropriateNumber);
      // button.addActionListener(new sudokuListener());
      // myGrid.add(button);
    }
  }