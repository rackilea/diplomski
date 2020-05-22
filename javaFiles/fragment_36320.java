private class ButtonListener implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
     JButton selectedButton = (JButton) e.getSource();

     int selectedRow = -1;  // initialize with non-viable value
     int selectedCol = -1;

     for (int row = 0; row < buttonGrid.length; row++) {
        for (int col = 0; col < buttonGrid[row].length; col++) {
           if (selectedButton == buttonGrid[row][col]) {
              selectedRow = row;
              selectedCol = col;
           }
        }
     }
  }
}