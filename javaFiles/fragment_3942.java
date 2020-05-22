String input = "Clause 1. Stuff is a Clause here\nClause 2. More Clause stuff is here.";
String pattern = "Clause\\s*[0-9]+\\.((?!Clause\\s+[0-9]+\\.).)*";
Pattern r = Pattern.compile(pattern, Pattern.DOTALL);
Matcher m = r.matcher(input);

while (m.find()) {
    System.out.println("Found value: " + m.group(0));
}