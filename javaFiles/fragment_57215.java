String uri = 
    "http://localhost:8080/hello/";
URL url = new URL(uri);
HttpURLConnection connection = 
    (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");
connection.setRequestProperty("Accept", "application/json");