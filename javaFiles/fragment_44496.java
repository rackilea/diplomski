// remove whitespace and escape backslash!
String regex = "(func1)(\\()(.{1,64})(,\\s*)([^)]{1,64})(\\))";
String input = "func2(func1(ef5b, 7dbdd))";
Pattern p = Pattern.compile(regex); // java.util.regex.Pattern
Matcher m = p.matcher(input); // java.util.regex.Matcher
if(m.find()) { // use while loop for multiple occurrences
    String param1 = m.group(3);
    String param2 = m.group(5);

    // process the result...
}