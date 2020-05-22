public static final Pattern DIGITS = Pattern.compile("(\\d+)");

public static void main(String[] args) {
  String text = "Some text before a number 123456 and some after";
  for (int i = 0; i < 5; i++) {
    timeRegex(text);
    timeLooping(text);
  }
}

private static int timeLooping(String text) {
  int ret = 0;
  final int runs = 1000;
  long start = System.nanoTime();
  for (int r = 0; r < runs; r++) {
    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
      if (ch <= '9' && ch >= '0')
        ret = ret * 10 + ch - '0';
      else if (ret > 0)
        break;
    }
  }
  long time = System.nanoTime() - start;
  System.out.printf("Took %,d ns to use a loop on average%n", time / runs);
  return ret;
}

private static int timeRegex(String text) {
  int ret = 0;
  final int runs = 1000;
  long start = System.nanoTime();
  for (int r = 0; r < runs; r++) {
    Matcher m = DIGITS.matcher(text);
    if (m.find())
      ret = Integer.parseInt(m.group());
  }
  long time = System.nanoTime() - start;
  System.out.printf("Took %,d ns to use a matcher on average%n", time / runs);
  return ret;
}