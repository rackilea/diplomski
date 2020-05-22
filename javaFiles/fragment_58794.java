String url = "http://www.omdbapi.com/";
String charset = "UTF-8";
String title = "Game of Thrones";
String season = "5";
String episode "5";

String query = String.format("t=%s&season=%s&episode=%s", 
     URLEncoder.encode(title, charset), 
     URLEncoder.encode(season, charset),
     URLEncoder.encode(episode, charset),);

URLConnection connection = new URL(url + "?" + query).openConnection();
connection.setRequestProperty("Accept-Charset", charset);
InputStream response = connection.getInputStream();
// Do some stuff with the data