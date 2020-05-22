public static Map<String, String> splitUrl(String urlText)  {
    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
    String query = urlText;
    String[] pairs = query.split("&");
    for (String pair : pairs) {
        int idx = pair.indexOf("=");
        query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
    }
    return query_pairs;
}

Map<String, String> splittedUrlMap = splitUrl(urlText);
String actualUrl =  splittedUrlMap.get("url");
System.out.println(actualUrl)'