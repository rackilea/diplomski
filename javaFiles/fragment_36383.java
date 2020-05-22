String parentNode = getParent(node).toString();
List<String> childElements = null;
if(map.contains(parentNode) {
    // List of child elements already exists, so get it from the Map.
    childElements = map.get(parentNode);
} else {
    // List of child elements does not yet exist, so create a new List
    // and add it to the Map.
    childElements = new ArrayList<>();
    map.put(parentNode, childElements);
}
childElements.add(node.toString());