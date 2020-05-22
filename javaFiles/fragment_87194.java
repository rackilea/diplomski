while (tokenMatcher.find()) {
  String replacement = "%" + String.valueOf(index++) + "\\$s";
  value = tokenMatcher.replaceFirst(replacement);
  tokenMatcher.reset(value); // reset
  System.out.println(value);
}