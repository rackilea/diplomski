void traverse() {
    if (head == null & tail == null)
        System.out.println("The stack is empty, Operation failed");
    obj cursor = null;
    System.out.println("    TAIL");
    System.out.println("\t|");
    System.out.println("\t|");
    System.out.println("\t|");
    System.out.println("\tV");
    cursor = tail;
    while (cursor != null) {
        System.out.println(cursor.field());
        System.out.println("\t|");
        System.out.println("\t|");
        System.out.println("\t|");
        System.out.println("\tV");
        cursor = cursor.back();
    }
    System.out.println("    HEAD");
}