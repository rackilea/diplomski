String age = JOptionPane.showInputDialog("What was your age yesterday?");
try {
  iage = Integer.parseInt(age);
} catch (NumberFormatException nfe) {
  // show error
}