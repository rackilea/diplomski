Pattern stringPattern = Pattern.compile("String [^=]*= \\"([^\\"]*)\\"");
boolean searchComment = true;
for (String line:fileLines) {
    if(searchComment) {
        searchComment = !line.contains(statement);
    } else {
        Matcher m = stringPattern.matcher(line);
        if (m.matches()) {
            String value = m.group(1);
        }
    }
}