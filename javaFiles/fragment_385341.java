List<String> foo = new MyListImplementation<String>();
foo.add("a");
foo.add("b");

// The enhanced for loop uses Iterable/Iterator for non-arrays
for (String x : foo) {
    for (String y : foo) {
        System.out.println(x + " " + y);
    }
}