final Pattern NUMBER_MATCHER = Pattern.compile("_(\\d+)_(\\d+)");
  Matcher matcher = NUMBER_MATCHER.matcher(/* your file name */);
  if (matcher.find()) {
     System.out.println("matcher.group(1) = " + matcher.group(1));
     System.out.println("matcher.group(2) = " + matcher.group(2));
  }