Map<String, SampleClassOne> tmp=listOne.stream()
    .collect(Collectors.toMap(SampleClassOne::getMyFirstProperty, Function.identity()));
List<RootSampleClass> result = listTwo.stream()
    .flatMap(two -> Optional.ofNullable(tmp.get(two.getMyOtherProperty()))
            .map(one -> Stream.of(new RootSampleClass(one, two))).orElse(null))
    .collect(Collectors.toList());