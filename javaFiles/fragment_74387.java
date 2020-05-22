String arry = graphObject.getProperty("data").toString();
    JSONArray jsonNArray1 = new JSONArray(arry);
    JSONArray jsonNArray = new JSONArray();
    if (jsonNArray1.length() > 0) {
        JSONObject jsonObject1 = jsonNArray1.getJSONObject(1);
        jsonNArray = jsonObject1.getJSONArray("fql_result_set");
    }