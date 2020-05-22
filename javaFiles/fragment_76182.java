public static void parseJson(StringBuffer sb) throws JSONException {

    JSONObject obj = new JSONObject(sb.toString());


    JSONArray arr = obj.getJSONArray("value");

    for (int i = 0; i < arr.length(); i++) {
        System.out.println(arr.getJSONObject(i).getString("Name"));
    }
}