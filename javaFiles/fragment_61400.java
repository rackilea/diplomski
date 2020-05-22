String SPECIAL_REGEX_CHARS = "[()'\"\\[\\]*]";
String s = "\"te(st\""; // => "te\(st"
String result;
if (s.startsWith("\"") && s.endsWith("\"")) {
    result = "\"" + s.replaceAll("^\"|\"$", "").replaceAll(SPECIAL_REGEX_CHARS, "\\\\$0") + "\"";
}
else {
    result = s.replaceAll(SPECIAL_REGEX_CHARS, "\\\\$0");
}
System.out.println(result.toString());