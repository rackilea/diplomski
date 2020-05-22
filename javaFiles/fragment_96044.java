Map<String,List<SampleClassOne>> tmp=listOne.stream()
    .collect(Collectors.groupingBy(SampleClassOne::getMyFirstProperty));
List<RootSampleClass> result = listTwo.stream()
    .flatMap(two -> tmp.getOrDefault(two.getMyOtherProperty(), Collections.emptyList())
        .stream().map(one -> new RootSampleClass(one, two)))
    .collect(Collectors.toList());