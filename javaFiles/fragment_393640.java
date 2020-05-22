String s = "Hi there! My name is Phil. Nice to meet you.";
Pattern p = Pattern.compile("my name is (\\w*)", Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher(s);
if (m.find()) {
    System.out.println(m.group(1));
} else {
    System.out.println("No match to " + s);
}