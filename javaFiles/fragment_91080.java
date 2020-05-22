StringBuffer output = new StringBuffer(forename + ", " + surname);
Pattern pattern = Pattern.compile("\\b([A-Z][a-z]*)\\b");
Matcher matcher = pattern.matcher(output);
while (matcher.find()) {
    int i = matcher.start();
    output.setCharAt(i, Character.toUpperCase(output.charAt(i)));
}