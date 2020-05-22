CharSequence yourStringHere = "Functions.getJsonPath(Functions.getJsonPath(Functions.getJsonPath(Functions.unescapeJson(\"test\"), \"m2m:cin.as\"),\"payloads_ul.test\"),\"[/\"Dimming Value/\"]\",input[\"test\"][\"in\"])";
Matcher m = Pattern.compile("[\\[]?\\\"(\\/?.)*?\\\"[\\]]?")
        .matcher(yourStringHere);
while (m.find()) {
    String s = m.group();
    if (!s.startsWith("[") && !s.endsWith("]")) {
        allMatches.add(s);
    }
}