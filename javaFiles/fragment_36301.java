public static void main(String[] args) { 
    ArrayList<Set<Integer>> tree = new ArrayList<Set<Integer>>();
    Set<Integer> level1 = new HashSet<Integer>();
    level1.add(new Integer(1));

    Set<Integer> level2 = new HashSet<Integer>();
    level2.add(new Integer(2));
    level2.add(new Integer(3));

    Set<Integer> level3 = new HashSet<Integer>();
    level3.add(new Integer(4));

    Set<Integer> level4 = new HashSet<Integer>();
    level4.add(new Integer(5));
    level4.add(new Integer(6));
    level4.add(new Integer(7));

    tree.add(level1);
    tree.add(level2);
    tree.add(level3);
    tree.add(level4);

    DFS dfsSearch = new DFS(tree); 
    dfsSearch.initialize();
    dfsSearch.runDFS(dfsSearch.getRoot());

    for (Integer[] path : dfsSearch.getPaths()) { 
      System.out.println(Arrays.toString(path));
    }