public  void parseData(JSONArray array) {
    for (int i = 0; i < array.length(); i++) {
        College college = new College();
        JSONObject json = null;
        try {
            json = array.getJSONObject(i);
            college.setImageUrl(json.getString(Config.TAG_IMAGE_URL));
           String s = (json.getString(Config.TAG_NAME));
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            college.setName(s);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        listcollege.add(college);
    }  
    adapter.notifyDataSetChanged();
}