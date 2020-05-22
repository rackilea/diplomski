final int BLOCK_SIZE = 1000000;
List<byte[]> list = new LinkedList<>();
try {
    for (;;) {
        list.add(new byte[BLOCK_SIZE]);
        if (list.size() % 1000 == 0)
            System.out.println(list.size());
    }
} catch (@SuppressWarnings("unused") OutOfMemoryError e) {
    // Ignore
}
list.remove(0); // free some memory
System.out.println((list.size() + 1) + " Memory full");
for (int i = 0; i < 15; i++) {
    System.out.println(i);
    list.add(new byte[BLOCK_SIZE]);
    list.remove(0);
}
System.out.println("Done");