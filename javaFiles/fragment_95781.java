JButton myButton = new JButton();
myButton.setActionCommand("myButtonCommand");

public void actionPerformed(ActionEvent ae) {
  String actionCommand = ae.getActionCommand();
  if (actionCommand.equals("myButtonCommand")) {
    // do something...
  }
}