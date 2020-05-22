// This is defined somewhere. It could be a local variable or an instance
// field or whatever. There's no exception (except is has to be in scope).
Collection c = ...;
...
Orange orange = new Orange() {
    public int getPriority(Long id) {
        // Insert code that searches c.mySet for an instance of data
        // with the desired ID and return its Priority
    }
};
Collections.sort(c.myList, Foo.getComparator(orange));