String numStr = "15A";
try {
  int num = Integer.parseInt(numStr);
} catch (NumberFormatException nfe) {
  // not a number
}