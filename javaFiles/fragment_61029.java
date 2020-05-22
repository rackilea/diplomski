Pattern pattern = Pattern.compile(regexString);
// text contains the full text that you want to extract data
Matcher matcher = pattern.matcher(text);

while (matcher.find()) {
  String textInBetween = matcher.group(1); // Since (.*?) is capturing group 1
  // You can insert match into a List/Collection here
}