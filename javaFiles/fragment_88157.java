X - -    - X -    - - X
X - - or - X - or - - X
X - -    - X -    - - X

private boolean colWinner() {
  for (int i = 0; i < 3; i++) {
    String mark = button[i].getText();
    if (mark.equals(button[i+3].getText()) &&
        mark.equals(button[i+6].getText()) {
      return true;
    }
  }
  return false;
}