try {
  float value = Float.valueOf(text.input);
  // Do something with value - it's OK.
} catch (NumberFormatException e) {
  // text.input is not a float, handle appropriately...
}