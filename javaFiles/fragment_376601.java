public static String getAlpha(int num) {

    String result = "";
    while (num > 0) {
      num--; // 1 => a, not 0 => a
      int remainder = num % 26;
      char digit = (char) (remainder + 97);
      result = digit + result;
      num = (num - remainder) / 26;
    }

    return result;
  }