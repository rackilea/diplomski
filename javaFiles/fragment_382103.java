public void setUpSearch(JSONObject data_json){

    Iterator<String> keys = data_json.keys();
     scripts = new ArrayList<String>();

    while (keys.hasNext()) {
        //get the key
        String key = keys.next();
        scripts.add(key);
        Log.i(TAG, key);
        Log.i(TAG, String.valueOf(scripts));
    }