....
  public static void parse(String s) {
    boolean quote = false;
    int depth = 0;
    int splitPoint = 1; // drop the first '['
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case '"':
          quote = !quote;
          break;
        case '{':
        case '[':
          if (!quote) {
            depth += 1;
          }
          break;
        case '}':
        case ']':
          if (!quote) {
            depth -= 1;
          }
          break;
        case ',':
          if (!quote && depth == 1) {
            System.out.println(s.substring(splitPoint, i).trim()); // or store
            splitPoint = i + 1;
          }
          break;
      }
    }
    System.out.println(s.substring(splitPoint, s.length() - 1).trim()); // or store
  }
....