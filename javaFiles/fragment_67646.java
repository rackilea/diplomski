public Object find(String contentId, JSONObject node) {
    JSONObject currentNode = (node != null) ? node : this.txtContent;
    Iterator<?> nodeKeys = currentNode.keys();

    while ( nodeKeys.hasNext() ){

        try {
            String key = (String) nodeKeys.next();

            if (key.equals(contentId)) {
                if (currentNode.get(key) instanceof JSONObject) {
                    return currentNode.getJSONObject(key);
                } else {
                    return currentNode.getString(key);
                }
            } else if (currentNode.get(key) instanceof JSONObject) {
                Object foundObj = find(contentId, currentNode.getJSONObject(key));
                if (foundObj!=null) {
                    return foundObj;
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    return null;
}