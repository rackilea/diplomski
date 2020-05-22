list1.stream()
    .forEach(obj1 -> 
        list2.stream()
            .filter(obj2 -> obj1.getId().equals(obj2.getId()))
            .findFirst()
            .ifPresent(obj2 -> obj1.setxxxx(obj2.getxxxx()))
    );