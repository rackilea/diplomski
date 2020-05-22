public static HttpResponse SendGet(String Url, HashMap<String, 
                     String> hm, DefaultHttpClient httpClient) {
    HttpResponse response = null;
    if (hm == null) return null;
            HttpGet getMethod = new HttpGet(Url);
            response = httpClient.execute(getMethod); 
            return response;
}