X X X    - - -    - - -
- - - or X X X or - - -
- - -    - - -    X X X

private boolean rowWinner() {
  for (int i = 0; i < 3; i++) {
    String mark = button[3*i].getText();
    if (mark.equals(button[3*i+1].getText()) &&
        mark.equals(button[3*i+2].getText()) {
      return true;
    }
  }
  return false;
}