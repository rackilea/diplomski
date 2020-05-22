String booleanExpression = "((468551X68X304.NAOK == \"2\") and (468551X68X305.NAOK > \"2\") and (468551X68X308.NAOK != \"2000\" or 468551X68X308.NAOK > \"2000\")) ";
String regex = "\\d+X\\d+X\\d+\\.NAOK"; // Note that backslash pairs don't denote two backslashes here. Because we're representing the regex as a string literal, we have to use escape sequences to represent the backslashes in the regex

Matcher m = Pattern.compile(regex).matcher(booleanExpression);
ArrayList<String> variables = new ArrayList<>();
while(m.find()) // Match a NEW variable (one that wasn't matched in previous iterations
    variables.add(m.group()); // Add the matched variable to the ArrayList