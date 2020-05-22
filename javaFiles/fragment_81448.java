URL url = null;
try {
    url = new URL("http://localhost:8080/deleteservice");
} catch (MalformedURLException exception) {
    exception.printStackTrace();
}
HttpURLConnection httpURLConnection = null;
try {
    httpURLConnection = (HttpURLConnection) url.openConnection();
    httpURLConnection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
    httpURLConnection.setRequestMethod("DELETE");
    System.out.println(httpURLConnection.getResponseCode());
} catch (IOException exception) {
    exception.printStackTrace();
} finally {         
    if (httpURLConnection != null) {
        httpURLConnection.disconnect();
    }
}