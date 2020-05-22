String baseUrl = "http://www.arena-offshore.com/";
String output = "../../res2.php?res=site/big/08032016130016552-GEMI-gözcü1.jpg&g=500&u=335";
int start = output.indexOf("=") + 1;
int end   = output.indexOf("&", start);
String imageUrl = baseUrl + output.substring(start, end); 
// Gives:
// http://www.arena-offshore.com/site/big/08032016130016552-GEMI-g%C3%B6zc%C3%BC1.jpg