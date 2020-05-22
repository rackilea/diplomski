//first declare the pattern once in the class
static final Pattern pattern = Pattern.compile("\\s*(.*?)\\s*\\|");
...
//instead of the split loop:
String line = "City             |First Name| Second Name|Last Name| Foo |Bar |"; //br.readLine();
Matcher matcher = pattern.matcher(line);
int column = 1;
while (matcher.find(column == 1 ? 0 : matcher.end())) {
    String match = matcher.group(1);
    System.out.println("Column " + column + " is " + match.length() + "---" + match + ": Position " + (matcher.start() + 1));
    column++;
}