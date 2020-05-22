String subject = "test/$name$/something";
String replace = "foo_bar";
Pattern regex = Pattern.compile("\\$([^$]*)\\$"); // ONLY 1 GROUP ROUND [^$]*
Matcher m = regex.matcher(subject);
StringBuffer b= new StringBuffer();
while (m.find()) {
    String something = m.group(1); // ACCESS GROUP 1
    System.out.println(something);
    m.appendReplacement(b, replace);
}
m.appendTail(b);
String replaced = b.toString();
System.out.println(replaced);