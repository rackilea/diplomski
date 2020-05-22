String str = "http://t.co/UURRNlrK";
String p = "(http://(t\.co|bit\.ly).*)";

Pattern pattern = Pattern.compile(p);
Matcher matcher = pattern.matcher(str);

if(matcher.find())
System.out.println(matcher.group(0));