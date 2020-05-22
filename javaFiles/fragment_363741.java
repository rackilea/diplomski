private static boolean searchNode(Stack<JSONObject> chain,
                                  JSONObject currentNode, Predicate<JSONObject> condition) throws Exception {

    if (condition.test(currentNode)) {
        chain.push(currentNode);
        return true;
    }

    JSONArray children = currentNode.getJSONArray("frames");
    if (children == null) {
        return false;
    }

    for (int i = 0; i < children.length(); i++) {
        if (searchNode(chain, children.getJSONObject(i), condition)) {
            chain.push(currentNode);
            return true;
        }
    }

    return false;
}