// %[argument_index$][flags][width][.precision][t]conversion
String formatSpecifier
    = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])";
// The pattern that defines a placeholder
Pattern pattern = Pattern.compile(formatSpecifier);
// The String to test
String[] values = {
    "%d of %d",
    "This is my %s", 
    "A simple content.", 
    "This is 100%", "Hi! My name is %s and I have %d dogs and a %d cats."
};
// Iterate over the Strings to test
for (String value : values) {
    // Build the matcher for a given String
    Matcher matcher = pattern.matcher(value);
    // Count the total amount of matches in the String
    int counter = 0;
    while (matcher.find()) {
        counter++;
    }
    // Print the result
    System.out.printf("%s=%d%n", value, counter);
}