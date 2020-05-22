X - -    - - X
- X - or - X -
- - X    X - -

private boolean diagWinner() {
  String mark = button[4].getText();
  return 
    (mark.equals(button[0].getText()) && mark.equals(button[8].getText()) ||
    (mark.equals(button[2].getText()) && mark.equals(button[6].getText());
}