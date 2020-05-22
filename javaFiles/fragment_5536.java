class BookList {

    private Book[] books = new Book[100]; // Or some maximum length
    private int size;

    public void add(Book book) {
        this.books[this.size] = book;
        this.size++;

        // You could optionally 'extend' the array with System.arraycopy
        // when the internal array exceeds 100, but I'll leave that to
        // you
    }
}