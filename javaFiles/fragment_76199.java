private boolean containsOnlyNumbers(String text) {
     Pattern pattern = Pattern.compile("\\d*(\\.\\d{0,2})?");
     Matcher matcher = pattern.matcher(text);
     boolean isMatch = matcher.matches();
     return isMatch;
  }