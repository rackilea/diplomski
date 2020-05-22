public class regex {
  public static void main(String[] args) throws Exception {
    String haystack = "ab";
    String needle = "abab?.*";
    for (int i = 0; i < 7; i++) haystack = haystack + haystack;
    for (int i = 0; i < 4; i++) needle = needle + needle;
    System.out.println(haystack.length() + " " + needle.length());
    long before = System.currentTimeMillis();
    System.out.println(Pattern.matches(needle, haystack));
    long after = System.currentTimeMillis(); // long after indeed...
    System.out.println(after - before);
  }
}