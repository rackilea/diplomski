int block_id;
try{
    JSONObject jObj = jsonarray.getJSONObject(i);
    block_id = jObj.has("block_id") ? jObj.getInt("block_id") : 0;
} catch (JSONException | NullPointerException e) {
    e.printStackTrace();
}