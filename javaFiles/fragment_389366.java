String line = "abc_dfgb_tf";
String pattern1 = "(\\w+)([+-]*)(\\d*)(\\w*)";
Pattern r1 = Pattern.compile(pattern1);
Matcher m1 = r1.matcher(line);

if (m1.find()) {
    System.out.println("Found value: " + m1.group(1));
    System.out.println("Found value: " + m1.group(2));
    System.out.println("Found value: " + m1.group(3));
    System.out.println("Found value: " + m1.group(4));
}