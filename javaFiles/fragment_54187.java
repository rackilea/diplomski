String url="www.example.com/";
int slash=url.lastIndexOf("/");


StringBuilder myURL = new StringBuilder(url);

if(url.endsWith("/")){
   myURL.setCharAt(slash, ' ');
   url=myURL.toString();
}

url=url.replaceAll("\\s+","");
System.out.println(url);