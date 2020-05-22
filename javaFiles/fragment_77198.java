Pattern p = Pattern.compile("#(\\w+)");
Matcher m = p.matcher(value);
while (m.find()) {
    String s = m.group(1);
    System.out.println("answer : " + s);
}