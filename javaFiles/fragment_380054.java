public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    GZIPInputStream gis = new GZIPInputStream(is);
    try {
        BufferedReader rd = new BufferedReader(new InputStreamReader(gis, Charset.forName("UTF-8")));
        String jsonText = readAll(rd);
        JSONObject json = new JSONObject(jsonText);
        return json;
    } finally {
        is.close();
    }
}