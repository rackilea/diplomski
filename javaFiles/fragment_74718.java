private static final Pattern imgPattern = Pattern.compile("(.*)(\\d*)\\.(.*)");

public static String getNextImageName(String last) {
  // The pattern captures the numerical value and the extension
  Matcher matcher = imgPattern.matcher(last);
  if (!matcher.matches()) {
    throw new IllegalArgumentExecption("Not image pattern: " + last);
  }

  String prefix = matcher.group(1);
  String num = matcher.group(2);
  int numVal = Integer.value(num);
  String ext = matcher.group(3);

  return String.format("%s%0" + num.length() + "d.%s",
                prefix, numVal + 1, ext);
}