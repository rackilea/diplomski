JSONObject channels = jobj.getJSONObject(TAG_CHANNELS);
    Iterator<?> keys=channels.keys();
    while( keys.hasNext() )
    {
        String key = (String)keys.next();
        Log.e("Key", key);
        if( channels.get(key) instanceof JSONArray ){
            jsontags.add(key);
        }
    }