class Creator {

    Set<Stuff> set = new HashSet<Stuff>();

    // each time you create an object, do this
    void foo() {
        Stuff stuff = // what you create
        set.put(stuff);
    }

    // you get them like
    Set<Stuff> objectsCreatedByThis() { return Collections.unmodifiableSet(stuff); }

}