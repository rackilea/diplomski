String s = "Smith-Crane John-Henry";
Pattern pattern = Pattern.compile("\\s([A-Za-z]+)");
Matcher matcher = pattern.matcher(s);
if (matcher.find()) {
    System.out.println(matcher.group(1));
}