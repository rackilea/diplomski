public static JSONArray parseJsonFromUrl(String uri) throws IOException, JSONException {
    JSONArray array = null;
    try (Scanner sn = new Scanner(new URL(uri).openStream(), "UTF-8")){
      array = new JSONArray(sn.useDelimiter("\\A").next());
    }
    return array;
}