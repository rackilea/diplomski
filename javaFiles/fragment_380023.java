Pattern p1 = Pattern.compile("\\[@name=['\"](.*?)['\"]]");

Matcher m = p1.matcher(input);                      
while (m.find()) {
    System.out.println(m.group(1));
}