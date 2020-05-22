list1.forEach(object1 -> 
    object1.setTotal(
        object1.getTotal() - list2.stream()
            .filter(object2 -> object1.getId().equals(object2.getId()))
            .flatMap(object2 -> object2.getList3().stream()) // Stream<Object2> to Stream<Object3>
            .mapToInt(Object3::getTotal)                     // get each total
            .sum()                                           // sum them
    )
);