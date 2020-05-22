Map<String, Relation> map = new HashMap<>();
    for (Relation relation : Relation.values()) {
        map.put(relation.getValue(), relation);
    }

    if(map.containsKey("a banana")){
        System.out.println("You ordered a banana.");
    }