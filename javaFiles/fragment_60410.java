public Map<String, Object> attrListToMap(AttributeList attrList) {
    Map<String, Object> attributeMap = new HashMap<String, Object>(attrList.size());
    for(Attribute attr: attrList.asList()) {
        attributeMap.put(attr.getName(), attr.getValue());
    }
    return attributeMap;
}