String pattern = "\\(\\d+, \\[[\\(\\d+, \\d+\\), ]*\\(\\d+, \\d+\\)\\]\\)";
String test = "(10, [(1, 4482729), (2, 4395402), (10, 4390557), (1, 4520185)])";

Pattern p = Pattern.compile(pattern);
Matcher m = p.matcher(test);
boolean b = m.matches();
System.out.println(b);