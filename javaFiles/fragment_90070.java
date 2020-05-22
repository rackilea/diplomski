private BinaryOperator<List<String>> addToList() {
    return (list, str) -> {
        ((ArrayList<String>) list).addAll(str);
        return list;
    };
}

Map<String, List<String>> map = Stream.of(
        // first list
        one.stream()
                .collect(Collectors.toMap(
                        l -> "below 100", 
                        // we need List as map value
                        l -> Stream.of(l).collect(Collectors.toList()), 
                        // merge function
                        addToList(), 
                        // provide HashMap for result 
                        HashMap::new 
                // we can't stream collected Map directly, only through EntrySet
                )).entrySet(),
        // second list
        two.stream()
                .collect(Collectors.toMap(
                        l -> "above 100", 
                        l -> Stream.of(l).collect(Collectors.toList()),
                        addToList(), 
                        HashMap::new 
                )).entrySet()
        )
        // extract Entry<String, List<String>> 
        .flatMap(entrySet -> entrySet.stream())
         // convert Entry<String, List<String>> to Map<String, List<String>
        .collect(Collectors.toMap(
                entry -> entry.getKey(),
                entry -> entry.getValue()));