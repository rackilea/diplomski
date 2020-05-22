ArrayList<List<Integer>> group = new ArrayList<List<Integer>>();
group.add(Arrays.asList(1, 2, 3));
group.add(Arrays.asList(4, 5, 6));
group.add(Arrays.asList(7, 8, 9));
for (List<Integer> list : group) {
    for (Integer i : list) {
        System.out.print(i+" ");
    }
    System.out.println();
}