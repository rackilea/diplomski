// escape backslash!
String regex = "func1\\s*\\(\\s*([^\\s]{1,64})\\s*,\\s*([^\\s\\)]{1,64})\\s*\\)";
String input = "func2(func1 ( ef5b, 7dbdd ))";
Pattern p = Pattern.compile(regex); // java.util.regex.Pattern
Matcher m = p.matcher(input); // java.util.regex.Matcher
if(m.find()) { // use while loop for multiple occurrences
    String param1 = m.group(1);
    String param2 = m.group(2);

    // process the result...
}