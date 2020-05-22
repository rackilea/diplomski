public JSONObject toJSON(Node node, List<Node> others) {
    JSONObject json = new JSONObject();
    json.put("id", node.id); // and so on
    ...
    List children = new ArrayList<JSONObject>();
    for(Node subnode : others) {
        if(isChildOf(subnode, node)) {
            others.remove(subnode);
            children.add(toJSON(subnode, others));
        }
    }
    json.put("children", children);
    return json;
}