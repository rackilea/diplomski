Pattern myPattern = Pattern.compile("YOUR_REGEX_HERE");
Matcher myMatcher = myPattern.matcher("YOUR_TEXT_HERE");

int count = 0;
while (myMatcher.find())
    count ++;