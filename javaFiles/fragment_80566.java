try {
    JSONArray jsonArray = new JSONArray(yourResponseStrOrJson);
    for(int i = 0; i < jsonArray.length(); i++){
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        Log.d("ID", jsonObject.getString("_id"));
        //TOTO retrive other element
    }
}catch (JSONException e){
  e.printStackTrace();
}