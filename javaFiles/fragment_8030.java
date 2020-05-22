String test = "<html>\n<a href=\"http://www.mysite.com/photoid/potato.html\"><img src=\"quack-quack\" alt=\"hi\" /></a>\n</html>";
// This is exactly the pattern code you posted :
String pattern = new String(
    "<a href=\"http://www.mysite.com/photoid/(.*?)\"><img src=\"(.*?)\" alt=\"(.*?)\" /></a>");

Pattern p = Pattern.compile(pattern);
Matcher m = p.matcher(test);
m.find(); // returns true