public static String compress (String original) {
  StringBuilder compressed = new StringBuilder();
  char letter = 0;
  int count = 1;
  for (int i = 0; i < original.length(); i++) {
    if (letter == original.charAt(i)) {
      count = count + 1;
    }
    else {
      compressed = count !=1 ? compressed.append(count) : compressed;
      compressed.append(letter);
      letter = original.charAt(i);
      count = 1;
    }
  }

  compressed = count !=1 ? compressed.append(count) : compressed;
  compressed.append(letter);
  return compressed.toString();
}