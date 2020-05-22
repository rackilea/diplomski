List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);
list.add(4);

List<Integer> list2 = list.stream().map(n -> n * 2).collect(Collectors.toList());
    System.out.println(list2);