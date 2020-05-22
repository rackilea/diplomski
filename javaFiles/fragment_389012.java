private static final Pattern PATTERN_1 = Pattern.compile("\u00f5");
private static final Pattern PATTERN_2 = Pattern.compile(Character.toString((char) 241));

String original = new String("A" + (char) 245 + "\u00f1" + "D");
String replaced2 = PATTERN_1.matcher(original).replaceAll("B");
replaced2 = PATTERN_2.matcher(replaced2).replaceAll("C");
System.out.println(original + " -> " + replaced2);