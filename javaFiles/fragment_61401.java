String SPECIAL_REGEX_CHARS = "[()'\"\\[\\]*]";
//String s = "\"te(st\""; // => "te\(st"
//String s = "te(st"; // => te\(st
String s = "te\"st"; // => te\"st
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("(?s)\"(.*)\"|(.*)").matcher(s);
if (m.matches()) {
    if (m.group(1) == null) { // we have no quotes around
        m.appendReplacement(result, m.group(2).replaceAll(SPECIAL_REGEX_CHARS, "\\\\\\\\$0"));
    }
    else {
        m.appendReplacement(result, "\"" + m.group(1).replaceAll(SPECIAL_REGEX_CHARS, "\\\\\\\\$0") + "\"");
    }
}
m.appendTail(result);
System.out.println(result.toString());