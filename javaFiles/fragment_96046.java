Map<String, SampleClassOne> tmp=listOne.stream()
    .collect(Collectors.toMap(SampleClassOne::getMyFirstProperty, Function.identity()));
List<RootSampleClass> result = listTwo.stream()
    .filter(two -> tmp.containsKey(two.getMyOtherProperty()))
    .map(two -> new RootSampleClass(tmp.get(two.getMyOtherProperty()), two))
    .collect(Collectors.toList());