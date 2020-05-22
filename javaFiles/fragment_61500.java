Integer[] ints = {75, 2, 0, 1, 10, 25, 60, 40, 70, 2, 3, 4, 5, 6, 10, 15};
 List<Integer> lList = Arrays.asList(ints);
 final LinkedList unsorted = new LinkedList(lList);

 Collections.sort(unsorted);

 System.out.println("LinkedList (after sorting using Comparator): " + unsorted);