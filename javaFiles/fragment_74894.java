public boolean hasIllegalCharacters(String newString) {
  boolean hasIllegalChars = false;
  char[] illegalChars = {'!', '#', '$', '%', '^', '&', '*', '(', ')' };

  for (int i = 0; i < newString.length; i++) {
    for (int j = 0; j < illegalChars.length; j++) {
      if (newString.charAt(i) == illgalChars[j]) {
        hasIllegalChars = true;
      }
    }
  }

  return hasIllegalChars;
}