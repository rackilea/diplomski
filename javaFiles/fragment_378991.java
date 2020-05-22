URL url = new URL("http://example.com");
HttpURLConnection connection = (HttpURLConnection)url.openConnection();
connection.setRequestMethod("GET");
connection.connect();

int code = connection.getResponseCode();
if (code>=200 && code <= 209){
    //...
}