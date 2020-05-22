// Being T the class of the objects in the list
ArrayList<T> list1 = ...;
ArrayList<T> list2 = ...;

// A function to compare two elements
BiFunction<T, T, Boolean> funcEquals = (a,b) -> yourEquals(a,b);
// A function that given a List returns a predicate that states if an element is on that list
Function<List<T>, Predicate<T>> notIn = (s) -> (e) -> s.stream().filter((y) -> funcEquals.apply(e, y)).count() == 0;

// Get the elements in list1 that are not in list2
Stream<String> list1Filtered = list1.stream().filter(notIn.apply(list2));
// Get the elements in list2 that are not in list1
Stream<String> list2Filtered = list2.stream().filter(notIn.apply(list1));
/*
If you have more than two lists, comparisons can be concatenated:
Stream<String> list1Filtered = list1.stream().filter(notIn.apply(list2)).filter(notIn.apply(list3));
Stream<String> list2Filtered = list2.stream().filter(notIn.apply(list1)).filter(notIn.apply(list3));
Stream<String> list3Filtered = list3.stream().filter(notIn.apply(list1)).filter(notIn.apply(list2));
*/

// Add them all together
ArrayList<T> result = new ArrayList<T>();
result.addAll(list1Filtered.collect(Collectors.toList()));
result.addAll(list2Filtered.collect(Collectors.toList()));