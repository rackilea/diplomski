List<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 0));
 List<Integer> list1 = new ArrayList<>(Arrays.asList(0, 1, 1));
 List<Integer> list2 = new ArrayList<>(Arrays.asList(2, -1, 0));
 List<Integer> list3 = new ArrayList<>(Arrays.asList(0, -1, 2));
 List<Integer> list4 = new ArrayList<>(Arrays.asList(-1, 0, 2));
 List<Integer> list5 = new ArrayList<>(Arrays.asList(0, 0, 1));
 List<Integer> list6 = new ArrayList<>(Arrays.asList(1, 0, 0));

 Set<List<Integer>> set = new HashSet<>(Arrays.asList(list,
                                                     list1,
                                                     list2,
                                                     list3,
                                                     list4,
                                                     list5,
                                                     list6));


Set<List<Integer>> result = set.stream()
                               .map(l -> l.stream()
                                          .sorted()
                                          .collect(Collectors.toList()))
                               .collect(Collectors.toSet());

System.out.println(result);