public class Bookshelf implements java.io.Serializable {
    private List<Book> books = new ArrayList<Book>(0);
    ...

    public void addBook(Book book) {
        books.add(book);
        book.setBookshelf(this);
    }
}