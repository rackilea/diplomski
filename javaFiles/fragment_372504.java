Pattern p = Pattern.compile("\\bClass\\s+(\\w+)\\b");

Matcher m = p.matcher(EXAMPLE_TEST);

while (m.find()) {
    System.out.println(m.group(1));
}