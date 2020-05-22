String input = "{\\rtlch\\fcs1 \\af39\\afs20 \\ltrch\\fcs0 \\fs20\\insrsid10175635\\charrsid8585274 \\hich\\af39\\dbch\\af31505\\loch\\f39 Build Job City:\\par \\hich\\af39\\dbch\\af31505\\loch\\f39 ^L\\hich\\af39\\dbch\\af31505\\loch\\f39 OT-CITY^}";
String tagRegex = "\\^(.*?)\\^";
Pattern tagRegexPattern = Pattern.compile(tagRegex, Pattern.DOTALL);
Matcher tagRegexPatternMatcher = tagRegexPattern.matcher(input);
while(tagRegexPatternMatcher.find()) {   // work
    String tag = tagRegexPatternMatcher.group(1);
    String controlWordRegex = "\\b(?:\\\\[a-zA-Z]+(-?[0-9]+)? ?)+ \\b";
    System.out.println(tag.replaceAll(controlWordRegex, ""));
}