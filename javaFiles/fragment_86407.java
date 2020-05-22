ArrayList<String> a1 = new ArrayList<String>();
    ArrayList<String> a2 = new ArrayList<String>();

    a1.add("a");
    a1.add("b");
    a1.add("c");
    a2.add("b");
    a2.add("a");

    System.out.println(a2.containsAll(a1));