// Matches 3 digits, a dash, 2 digits, a dash, and four digits, and then all text
// until it finds another SSN
String text = "987-65-4320 some info 987-65-4321 other \ninfo";
Pattern p = Pattern.compile("(\\d{3}-\\d{2}-\\d{4})((?:.(?!\\d{3}-\\d{2}-\\d{4}))*)", Pattern.DOTALL);
Matcher m = p.matcher(text);
while (m.find())
    System.out.println(m.group(1) + ": " + m.group(2));