private JSONArray modifyJsonArray(JSONArray array, final List<Integer> param) throws JSONException {
    List<JSONObject> jsons = new ArrayList<JSONObject>();
    mainJsons = new ArrayList<JSONObject>();
    for (int i = 0; i < array.length(); i++) {
        Integer id = Integer.parseInt(array.getJSONObject(i).getString("id"));
        mainJsons.add(array.getJSONObject(i));
        for (int j = 0; j < param.size(); j++){
            if (statusId == param.get(j)) {
                jsons.add(array.getJSONObject(i));
            }
        }
    }
    return new JSONArray(jsons);
}