Pattern pattern = Pattern.compile("Name '(.*)' (\d*)-years old");
for (String line : lines) {
    Matcher matcher = pattern.matcher(line);
    if (matcher.matches()) {
        String theName = matcher.group(1);
        int theAge = Integer.parseInt(matcher.group(2));
    }
}