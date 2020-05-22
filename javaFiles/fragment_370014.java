Integer[] subset = new Integer[]{10, 20, 30};
    Integer[] superset = new Integer[]{10, 20, 30, 40, 60};
    HashSet<Integer> sublist = new HashSet<Integer>(Arrays.asList(subset));
    HashSet<Integer> suplist = new HashSet<Integer>(Arrays.asList(superset));
    boolean isSubset = suplist.containsAll(sublist);
    System.out.println(isSubset);