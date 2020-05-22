String str = " <play> a < b  <play> at < button >\n <play> a < 90 <play> at < button >\nhgsf a< sjdfvh> dasjfh a>jsdhf a<fan> a< button and > sjf";
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("(\\s*<\\s*\\w+\\s*>\\s*)|\\s*([<>])\\s*").matcher(str);
while (m.find()) {
    String replacement = m.group(1) != null ? // Check if Group 1 is matched
        m.group(1) : //If yes, use Group 1
        (m.group(2).equals("<") ? " less than " : " greater than "); // If not, replace Group 2
    m.appendReplacement(result, replacement); //  Add the replacement
}
m.appendTail(result);
System.out.println(result.toString());