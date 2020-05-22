List<FooModel> outputList = inputList
    .stream()
    .collect(Collectors.groupingBy(Foo::getGroup))// create Map<Foo.Group,List<Foo>>
.entrySet().stream() // go through entry set to create FooModel
.map(
entry-> new FooModel (
entry.getKey(),
entry.getValue()
)
).collect(Collectors.toList());