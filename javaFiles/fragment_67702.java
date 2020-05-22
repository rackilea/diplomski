Pattern p = Pattern.compile("\\bat\\s+(\\w+)");
String s1 = "I am at Boston at Downtown";
Matcher m = p.matcher(s1);
while (m.find()) {
    System.out.println(m.group(1));
}