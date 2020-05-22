public class Requester {
  public static final String INPUT = 
      "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8";
  public static final String REPLACEMENT = "replacement";

  public static final Pattern REGEX = 
      Pattern.compile("(?<before>jdbc:mysql:\\/\\/[^:\\/]+(?::[0-9]+)?\\/)[^?]+(?<after>\\?.*)?");

  public static void main(final String... args) {
    Matcher m = REGEX.matcher(INPUT);

    if (!m.matches()) {
      throw new AssertionError("Bad URL");
    }
    final String before = m.group("before");
    final String after = m.group("after");

    StringBuilder sb = new StringBuilder();
    sb.append(before);
    sb.append(REPLACEMENT);
    if (after != null) {
      sb.append(after);
    }

    System.out.println(sb);
  }
}