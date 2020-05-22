private JSONObject removeEmpty(JSONObject root) {
    ArrayList<Object> toRemove = new ArrayList<>();
    root.keys().forEachRemaining(key -> {
        Object value = root.get(key);
        if (value instanceof JSONObject) {
            removeEmpty((JSONObject) value);
        } else if(value.equals("")) {
            toRemove.add(key)
        }
    });

    foreach (Object o : toRemove) {
        root.remove((String)o);
    }

    return root;
}