String input = "root 14139 1 25 Aug03 ? 06:47:50 /usr/local";
Pattern pattern = Pattern.compile("^\\S+\\s+(\\d+)");
Matcher matcher = pattern.matcher(input);
if (matcher.find()) {
    System.out.println(matcher.group(1));
}