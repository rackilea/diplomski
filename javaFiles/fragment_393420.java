Pattern pattern = Pattern.compile("\\$while\\((.*?)\\)(.*?)\\$endWhile", Pattern.DOTALL);
Matcher matcher = pattern.matcher(yourString);
StringBuffer sb = new StringBuffer();
while(matcher.find()){
    String variable = matcher.group(1); // this will include the $
    String value = matcher.group(2);
    // now do something with variable and value
    matcher.appendReplacement(sb, value);
}
matcher.appendTail(sb);