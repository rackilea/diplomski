private static final Pattern
  rx1 = Pattern.compile("..."),
  rx2 = Pattern.compile("..."),
  ...;

return rx1.matcher(s).matches() || rx2.matcher(s).matches() || ...;