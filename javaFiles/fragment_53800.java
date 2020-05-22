LinkedList<String> result = new LinkedList<String>();
LinkedList<String> children = map.get(rn).getListOfChildren();
result.addAll(children);
for (String child : children) {
    result.addAll(descendantsRN(child , map));
}
return result;