Pattern p = Pattern.compile(".*?(?: at (\\w+))+.*");
String s1 = "I am at Boston at Downtown";
Matcher m = p.matcher(s1);
if (m.matches()) {
    System.out.println(m.group(1));
}