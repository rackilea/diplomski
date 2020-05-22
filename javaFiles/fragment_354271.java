String text = "http://69.39.233.135:8032 http://83.133.127.104 http://119.207.75.238:11120";        
String pattern = "(http://\\d{1,3}(?:\\.\\d{1,3}){3}(?::\\d{1,5})?)";

Pattern compiledPattern = Pattern.compile(pattern);
Matcher matcher = compiledPattern.matcher(text);
while(matcher.find()) {
    System.out.println(matcher.group());
}