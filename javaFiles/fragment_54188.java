String url="www.example.com/";
int slash=url.lastIndexOf("/");

StringBuilder myURL = new StringBuilder(url);
myURL.deleteCharAt(slash);
System.out.println(myURL);