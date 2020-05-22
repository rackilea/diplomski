String url= "http://www.youtube.com/watch?v=mmmc&feature=plcp";
String search = "v=";
int index     = url.indexOf(search);
int index2    = url.indexOf("&",index);
String found  = url.substring(index+2,index2);
System.out.println(found);