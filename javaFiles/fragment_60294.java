String re = "^.*?\\bgoing(\\s+\\w+){0,3}\\s+work\\b.*$";
String str = "I am going one two three work";
System.out.printf("Matches: %s%n", str.matches(re)); // true

str = "I am going one two three four work";
System.out.printf("Matches: %s%n", str.matches(re)); // false