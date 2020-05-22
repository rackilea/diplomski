List<String> l = new CopyOnWriteArrayList<>();
    l.add("a");
    l.add("b");
    l.add("c");
    Iterator<String> itr = l.iterator();
    l.add("d");
    while (itr.hasNext()) {
        String s = itr.next();
        System.out.println(s);
    }
    System.out.println(l);