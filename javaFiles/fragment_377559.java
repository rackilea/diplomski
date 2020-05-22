actionPerformed(ActionEvent e) {
  Color clr = loop.next();
  if (clr == GREEN) {
    green.turnOn(true);
    yellow.turnOn(false);
    red.turnOn(false);
  }
  //<continue there for other colors>
}