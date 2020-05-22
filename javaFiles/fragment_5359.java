String name = "José";
String type = "artist";
// ...
String url = String.format("http://XXX.php?name=%s&type=%s", 
    URLEncoder.encode(name, "UTF-8"), 
    URLEncoder.encode(type, "UTF-8"));