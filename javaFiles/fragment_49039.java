int r = -1;
int c = -1;
for (int row = 0; row < buttons.length; row++) {
  for (int col = 0; col < buttons[row].length; col++) {
    if (buttons[row][col] == e.getSource()) {
      r = row;
      c = col;
    }
  }
}