ArrayList<Integer> a = new ArrayList<Integer>();
    a.add(3);
    a.add(4);
    a.add(5);
    a.add(6);
    System.out.println(a);
    List<Integer> b = a.subList(1, a.size());
    System.out.println(b);