public static String capitalizeEveryNthWord(String sentence, Integer offset, Integer n) {
  StringBuilder sb = new StringBuilder(sentence);
  int wordIdx = 0;
  boolean newWord = true;
  for (int i = 0; i < sb.length(); i++) {
    char c = sb.charAt(i);
    if (c == ' ') {
      wordIdx++; // assumes single space between words.
      newWord = true;
    } else if (newWord) {
      if (wordIdx >= offset && (wordIdx - offset) % n == 0) {
        sb.setCharAt(i, Character.toUpperCase(c));
      }
      newWord = false;
    }
  }
  return sb.toString();
}