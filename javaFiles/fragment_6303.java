public static String alternatingCaps(String s) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (i % 2 == 0) {
        result.append(Character.toLowerCase(s.charAt(i)));
      } else {
        result.append(Character.toUpperCase(s.charAt(i)));
      }
    }
    return result.toString();
 }