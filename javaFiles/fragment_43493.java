Set<Foo> fooSet1 = new HashSet<>(list1);
Set<Foo> fooSet2 = new HashSet<>(list2);

fooSet1.removeAll(list2);
fooSet2.removeAll(list1);

List<Foo> notInIntersectList = Stream.concat(fooSet1.stream(), fooSet2.stream())
            .collect(Collectors.toList());