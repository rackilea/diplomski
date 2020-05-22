JSONArray arr = new JSONArray(response);

for (int i = 0; i < arr.length(); i++) {
     root.addChild(decodeMessages(arr.getJSONObject(i)));
}

private String decodeMessages(JSONObject jsonObject) {
    TreeNode treeNode;
    // decode message from json
    try {
        JSONArray jsonArray = jsonObject.getJSONArray("children");
        for (int i = 0; i < jsonArray.length(); i++) {
            treeNode.addChild(decodeMessages(jsonArray.getJSONObject(i)));
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }

    return treeNode;
}