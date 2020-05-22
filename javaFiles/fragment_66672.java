public static ArrayList<MapData> getData() {
    try {

        String URL = "http://sml.com.pk/a/map.php";
        HttpParams httpparams = new BasicHttpParams();

        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("http", new PlainSocketFactory(), 80));

        DefaultHttpClient client = new DefaultHttpClient(
                new ThreadSafeClientConnManager(httpparams, registry),
                httpparams);

        HttpGet httpGet = new HttpGet(URL);

        HttpResponse response = client.execute(httpGet);
        String string_response = EntityUtils.toString(response.getEntity(),
                "UTF-8");
        JSONArray JsonResponse;
        try {
            JsonResponse = new JSONArray(string_response);

            ArrayList<MapData> list = new ArrayList<MapData>();
            for (int i = 0; i < JsonResponse.length(); i++) {
                String GPS = JsonResponse.getJSONObject(i).getString("GPS");
                String temp[] = GPS.split(",");
                MapData apoint = new MapData();
                apoint.lat = temp[0];
                apoint.lon = temp[1];
                list.add(apoint);

            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    } catch (ClientProtocolException e) {
        e.printStackTrace();
        return null;
    } catch (IOException e) {

        e.printStackTrace();
        return null;

    }


}

 public static class MapData {
        public String lat;
        public String lon;
    }