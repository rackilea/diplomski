..
JSONArray jsonMainNode = jsonResponse.optJSONArray("items");

for (int i=0; i<jsonMainNode.length(); i++) {

    JSONObject finalNode = jsonMainNode.getJSONObject(i);
    JSONArray finalArray = finalNode.optJSONArray("media");

    for (int j=0; j<finalArray.length(); j++) {
        String m = finalArray.getJSONObject(j).getString("m");
    }

}