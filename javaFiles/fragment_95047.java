//Pattern and Matcher
Pattern compiledPattern = Pattern.compile(myPatternString);
Matcher matcher = pattern.matcher(myStringToMatch);
boolean isNextMatch = matcher.find(); //find next match, it exists, 
if(isNextMatch) {
    String matchedString = myStrin.substring(matcher.start(),matcher.end());
}