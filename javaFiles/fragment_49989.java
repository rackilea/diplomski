Pattern pattern = Pattern.compile("\\b\\pL+(?:-\\pL+)*\\b", Pattern.UNICODE_CHARACTER_CLASS);
Matcher matcher = pattern.matcher("5 * loop-num + 5");
if(matcher.find()){
    String extractedString = matcher.group(0);
    System.out.println(extractedString);
}