String line = "SELECT a, b, c FROM X....";
String pattern = "((FROM|from).*)";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(line);

if (m.find()) {
     System.out.println("Found value: " + m.group(0));
}