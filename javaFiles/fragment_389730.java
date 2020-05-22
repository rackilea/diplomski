List<String> s = new ArrayList<>();
s.add("one");
s.add("two");
s.add("three");

String step1 = StringUtils.join(s, "\", \"");// Join with ", "
String step2 = StringUtils.wrap(step1, "\"");// Wrap step1 with "

System.out.println(step2);