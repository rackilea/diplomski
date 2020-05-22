String inputString = "Smith, John (111) 123-4567";

String regexPattern = "(?<lastName>.*), (?<firstName>.*) \\((?<cityCode>\\d+)\\).*";
Pattern pattern = Pattern.compile(regexPattern);
Matcher matcher = pattern.matcher(inputString);

if (matcher.matches()) {
      out.printf("%s %s %s", matcher.group("firstName"),
                                        matcher.group("lastName"),
                                        matcher.group("cityCode"));
}