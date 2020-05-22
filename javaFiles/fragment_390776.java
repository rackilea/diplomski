...
JSONArray jsonMainNode = jsonResponse.optJSONArray("items");

for (int i=0; i<jsonMainNode.length(); i++) {

    String media = jsonMainNode.getJSONObject(i).getString("media");
}