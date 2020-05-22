public static JSONObject build(Map<String, String> data) {
    JSONObject json = new JSONObject();
    //Iterate the map entries
    for (Entry<String, String> e : data.entrySet()) {
        String[] keys = e.getKey().split("\\.");

        // start from the root
        JSONObject current = json;
        for (int i = 0; i < keys.length; ++i) {
            String key = keys[i];

            //Search for the current node
            try {
                //If it exist, do nothing
                current = current.getJSONObject(key);
            } //If it does not exist
            catch (JSONException ex) {
                //Is it the last node, create the value
                if (i == keys.length - 1) { 
                    current.put(key, e.getValue());
                } //Not the last node, create a new JSONObject
                else { 
                    JSONObject tmp = new JSONObject();
                    current.put(key, tmp);
                    current = tmp; //Always replace current with the last node to go deeped each iteration
                }
            }
        }

    }

    return json;
}