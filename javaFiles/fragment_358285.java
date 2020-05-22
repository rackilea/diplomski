String someHTML = //get your HTML from wherever
String lKeyword = "rtTop";
String lRegexPattern = "(.*)(<script[^>]*>(((?!</).)*)"+lKeyword +"(((?!</).)*)</script>)(.*)";
Pattern pattern = Pattern.compile(lRegexPattern ,Pattern.DOTALL);
Matcher myMatcher = pattern.matcher(someHTML);
myMatcher.find();
String lPreKeyword = myMatcher.group(3);
String lPostKeyword = myMatcher.group(5);
String result = lPreKeyword + lKeyword + lPostKeyword;