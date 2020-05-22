class BookStuff {
    private static Book[] inventory;
    private static final int MAX_BOOKS = 5;

    static void createBooks() {
        inventory = new Book[MAX_BOOKS];
        // ...
    }

    static void readBook(int index) {
        inventory[index].read();
    }
}