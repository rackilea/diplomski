private static Map<String, String> traverseNodes(Node n) {
    Map<String, String> map = new HashMap<String, String>();
    traverseNodesRecurse(n, map);
    return map;
}

private static void traverseNodesRecurse(Node n, Map<String, String> map) {
    // Logic as per question
    // Recursive call (in the loop, etc)
    traverseNodes(childNode, map);

    // No need for a return statement
}