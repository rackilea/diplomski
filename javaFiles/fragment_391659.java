double inhourInput = 0.0;
String inhour = inh.getText();
try {
   inhour = inh.getText();
   inhourInput = Double.valueOf(inhour);
}
catch (NumberFormatException e) {
  // do not really need to reset to 0, but can be useful for clarity
  inhoutInput = 0.0;
}