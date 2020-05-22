List<String> valueList = .... 

return Observable.from(valueList)
    .map(string -> SomeClass.doOperationThatReturnsObservable(string))
    .toList()
    .flatMap(listOfObs -> Observable.zip(listOfObs, (Object[] results) -> {
       // do something with the strings in the array.
       return Arrays.stream(results)
                    .map(Object::toString)
                    .collect(Collectors.joining(","));
    }));