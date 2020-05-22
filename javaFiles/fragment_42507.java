String linkPattern = "\\[[A-Za-z_0-9]+\\]";
String text = "[build]/directory/[something]/[build]/";
Pattern pat = Pattern.compile(linkPattern);
Matcher mat = pat.matcher(text);
while (mat.find()) {
    System.out.println(mat.group());
}