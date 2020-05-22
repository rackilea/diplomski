String[] arr = {"a", "b", "e", "f"};
List<String> arrList = Arrays.asList(arr); // create a List from the array so that we can call "contains".
                                           // If the array is constant, you should just directly create a List instead.

Set<TestObj> objectsToReturn =
        allObjects.stream()
        .filter(x -> arrList.contains(x.getStr()))
        .collect(Collectors.toSet());