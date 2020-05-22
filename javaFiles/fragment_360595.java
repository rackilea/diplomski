Pattern pattern = Pattern.compile("([A-Z][a-z]*)([0-9]*)");
Matcher matcher = pattern.matcher(input);
while (matcher.find()) {
    String element = matcher.group(1);
    int count = 1;
    if (matcher.groupCount > 1) {
        try {
            count = Integer.parseInt(matcher.group(2));
        } catch (NumberFormatException e) {
            // Regex means we should never get here!
        }
    }
    // Do stuff with this component
}