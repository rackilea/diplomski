public void modifiedJSON(JSONObject orgJson, String nodeStruct, 
                         String targetKey, String value)  {
    // Split the keys using . as separator 
    String[] keys = nodeStruct.split("\\.");
    // Used to navigate in the tree
    // Initialized to the root object
    JSONObject target = orgJson;
    // Iterate over the list of keys from the first to the key before the last one
    for (int i = 0; i < keys.length - 1; i++) {
        String key = keys[i];
        if (!target.has(key)) {
            // The key doesn't exist yet so we create and add it automatically  
            target.put(key, new JSONObject());
        }
        // Get the JSONObject corresponding to the current key and use it
        // as new target object
        target = target.getJSONObject(key);
    }
    // Set the last key
    target.put(targetKey, value);
}