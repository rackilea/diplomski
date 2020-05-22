public boolean isNumber(String string) {
  for (int i = 0; i < string.length(); i++) {
    if (!Character.isDigit(string.charAt(i))) {
      return false;
    }
  }

  return true;
}