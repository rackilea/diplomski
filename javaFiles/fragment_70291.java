List<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 0));
List<Integer> list1 = new ArrayList<>(Arrays.asList(0, 1, 1));
List<Integer> list2 = new ArrayList<>(Arrays.asList(2, -1, 0));
List<Integer> list3 = new ArrayList<>(Arrays.asList(0, -1, 2));
List<Integer> list4 = new ArrayList<>(Arrays.asList(-1, 0, 2));

Set<List<Integer>> set = new HashSet<>(Arrays.asList(list, 
                                                     list1, 
                                                     list2,
                                                     list3, 
                                                     list4));
//keeps track of what was added before
 HashSet<Set<Integer>> added = new HashSet<>();

//converting the list to a set in the Predicate
//as you want to check the elements not their order
set.removeIf(l -> !added.add(new HashSet<Integer>(l)));

System.out.println(set);