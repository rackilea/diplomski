Set<String> attributeTypes;
    String id = ss.split("\\.")[2];
    if(userAttribute.containsKey(id))
        attributeTypes = userAttribute.get(id);
    else
        attributeTypes = new LinkedHashSet<String>();

    attributeTypes.add(ss.split("\\.")[0]);

    userAttribute.put(id, attributeTypes);