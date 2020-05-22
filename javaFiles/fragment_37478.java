Set<Object> weakSet = Collections.newSetFromMap(new WeakHashMap<>());
    weakSet.add(new Object());
    System.out.println(weakSet.size()); // prints "1"
    while (weakSet.size() > 0)
        System.gc();
    System.out.println(weakSet.size()); // prints "0"