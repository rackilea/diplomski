List<String> list1 = ImmutableList.of("a","b","c"); // factory method
List<String> list2 = ImmutableList.builder() // builder pattern
  .add("a")
  .add("b")
  .add("c")
  .build();

List<String> list3 = ...  // created by other means
List<String> immutableList3 = ImmutableList.copyOf(list3); // immutable copy, lazy if already immutable