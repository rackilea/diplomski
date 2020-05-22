private void parseJson(String jsonString){
    // now we initialize the ArrayList
    list = new ArrayList<>();
    try {
        JSONObject root = new JSONObject(jsonString);
        JSONArray dt = root.getJSONArray("data");
        int len = dt.length();

        // Check the length of the JSONArray object!
        Log.e(TAG, "Number of data objects = " + len);
        for (int i = 0; i < len; i++) {
            JSONObject chara = dt.getJSONObject(i);
            String s = chara.optString("character", "");
            if (!s.isEmpty()) {
                list.add(s);
            }
        }
        // The first value in the ArrayList start with the index value 0!!
        currentIndex = 0;
        String sText = list.get(currentIndex)
        Log.e(TAG, "First Value = " + sText);
        mTvAcc.setText(sText);
    }catch (JSONException e){
        Log.e(TAG, getMessage());
    }
}