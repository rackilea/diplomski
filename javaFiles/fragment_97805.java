String parameters = "<([\\w. ]+)>";

Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(string_to_match);

while (matcher.find()) {
    System.out.println(matcher.group());
}