static void dump(Object[] arr) {
    Iterator<Object> iter = new RecursiveIterator(arr);
    while (iter.hasNext()) {
        System.out.print(iter.next() + " ");
    }
    System.out.println("(done)");
}
public static void main(String[] args) throws FileNotFoundException {
    dump(new Object[] {
        1,
        2,
        new Object[] {
            3,
            new Object[] { 4 },
            5,
        },
        6,
        new Object[] {},
        7,
    });
    dump(new Object[] {
        new Object[] {},
        new Object[] {
            new Object[] {          
                new Object[] {},
            },
        },
        new Object[] {},
        new Object[] { null },
    });
}