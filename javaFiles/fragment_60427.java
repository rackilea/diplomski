public class MatchesPattern implements ArgumentMatcher<String> {
  private final Pattern pattern;
  public MatchesPattern(Pattern pattern) { this.pattern = pattern; }

  @Override public boolean matches(String string) {
    return pattern.matcher(string).matches();
  }

  @Override public String toString() {
    return "[string matching /" + pattern.toString() + "/]";
  }

  /** Optional. */
  public static MatchesPattern matchesPattern(Pattern pattern) {
    return new MatchesPattern(pattern);
  }
}