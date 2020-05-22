Pattern p = Pattern.compile("a*b"); // This is the Regular Expression to match
Matcher m = MY_PATTERN.matcher("aaaaaaab"); // This is the String to search through
while (m.find()) { // While there are matches found
    String s = m.group(1);  // Set String s equal to matches of the entire regex
    // s now contains "aaaaaaab"
}