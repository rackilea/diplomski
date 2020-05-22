String s = "foo address = \"foobar\" ";
Pattern regex = Pattern.compile("address\\s*=\\s*\\\"[^\"]*\\\"");
//System.out.println(s.matches(pattern));
Matcher regexMatcher = regex.matcher(s);
if (regexMatcher.find()) {
 String ResultString = regexMatcher.group();
 System.out.println(ResultString);
} //=> address = "foobar"