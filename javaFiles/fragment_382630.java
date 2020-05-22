public static void main(String[] args) throws Exception {
    JSONObject data = getJSONObjectFromUrl("http://www.qatar.cmu.edu/?feed=directory&q=john&category=0&subcategory=&employeeType=0&page=1");
    System.out.println(data);
}

private static JSONObject getJSONObjectFromUrl(String url) throws Exception {
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    // optional default is GET
    con.setRequestMethod("GET");
    //add request header
    con.setRequestProperty("User-Agent", "Mozilla/5.0");

    StringBuffer response;
    try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
        String inputLine;
        response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
    }

    return new JSONObject(response.toString());
}