String input = "type Database xyz{ abc }";
Pattern pattern = Pattern.compile("type\\s+(.*?)\\s+.*");
Matcher matcher = pattern.matcher(input);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}