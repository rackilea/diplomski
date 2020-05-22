int summation = myMap.values()
                     .stream()
                     .map(Map::values)
                     .flatMap(Collection::stream)
                     .flatMap(Collection::stream)
                     .mapToInt(MyObject::getField1)
                     .sum();