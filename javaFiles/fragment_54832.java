Map<Long, List<Long>> map = 
    list.stream()
        .collect(Collectors.groupingBy(
            MyClass::getStackId,
            Collectors.mapping(MyClass::getQuestionId, Collectors.toList())
        ));

List<MyOtherClass> result = 
    map.entrySet()
       .stream()
       .map(e -> new MyOtherClass(e.getKey(), e.getValue()))
       .collect(Collectors.toList());