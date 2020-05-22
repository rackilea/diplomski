public static void main(String[] args) throws Exception {

    BufferedReader reader = null;
    int page = 1;
    JSONObject jsonObject = null;
    try {
        while (jsonObject == null || jsonObject.getBoolean("has_more")) {
            String urlString = "https://api.stackexchange.com/2.1/questions?order=desc&sort=votes&tagged=java&site=stackoverflow&pagesize=100";
            urlString += "&page=" + page++;
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();

            InputStream isConn = connection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(isConn)));

            String inputLine;

            while ((inputLine = reader.readLine()) != null) {
                buffer.append(inputLine);
            }

            jsonObject = new JSONObject(buffer.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("items");

            System.out.println(buffer);
            System.out.println(jsonArray.length());
        }
    } finally {
        if (reader != null) {
            reader.close();
        }
    }

}