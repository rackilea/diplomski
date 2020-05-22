Matcher matcher = Pattern.compile("#[^)]{6}'").matcher(yourOldText);
StringBuffer sb = new StringBuffer();
while(matcher.find()){
    matcher.appendReplacement(sb, 
      // implement your custom logic here, matcher.group() is the found String
      someReplacement(matcher.group());
}
matcher.appendTail(sb);
String yourNewString = sb. toString();