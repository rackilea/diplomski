ArrayList<String> l1 = new ArrayList<>();
    ArrayList<String> l2 = new ArrayList<>();
    l1.add("asdf");
    l2.add("asdf");
    ArrayList<ArrayList<String>> coll = new ArrayList<>();
    coll.add(l1);
    System.out.println(coll.contains(l2));