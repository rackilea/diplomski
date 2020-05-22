public static LinkedList list = new LinkedList();

public LibraryUser() {
    count ++;
    // add to the list
    list.add(this);
}