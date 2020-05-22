Set<String> set = new HashSet<>();
    for (Relation relation : Relation.values()) {
        set.add(relation.getValue());
    }

    if(set.contains("a banana")){
        System.out.println("You ordered a banana.");
    }