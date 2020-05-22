Pattern pTag = Pattern.compile("@(\\w+)" + // tag
                               "\\{" +
                                  "(\\w+)" + // name
                                  "," +
                                  "([^{}]*(?:\\{[^{}]*\\}[^{}]*)*)" + // content
                               "\\}");
Pattern pField = Pattern.compile("(\\w+)" + // field
                                 "\\s*=\\s*" +
                                 "\\{" +
                                    "([^}]*)" + // value
                                 "\\}");
Pattern pNewline = Pattern.compile("\\s*(?:\\R\\s*)+");
for (Matcher mTag = pTag.matcher(input); mTag.find(); ) {
    String tag = mTag.group(1);
    String name = mTag.group(2);
    String content = mTag.group(3);
    for (Matcher mField = pField.matcher(content); mField.find(); ) {
        String field = mField.group(1);
        String value = mField.group(2);
        value = pNewline.matcher(value).replaceAll(" ");
        System.out.printf("%-15s %-12s %-11s %s%n", tag, name, field, value);
    }
}