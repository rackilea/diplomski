// Class Definition
public class Book {
    // Member Variables
    public int isbn;
    public int yearPublished;
    public String title;
    public String author;
    public String price;
    public int noOfCopies;

    // Constructor
    public Book(int ISBN, int year, String ttle, String auth, String pri, int copies) {

        this.isbn = ISBN;
        this.yearPublished = year;
        this.title = ttle;
        this.author = auth;
        this.price = pri;
        this.noOfCopies = copies;
    }

    // Create a List of Books
    public static List<Book> getBooks() {
        Book b1 = new Book(1234, 1991, "Book1", "mark.mark", "£11.00", 5);
        Book b2 = new Book(4321, 1994, "Book2", "bob.bob", "£12.00", 3);
        List<Book> books = new ArrayList<Book>();
        books.add(b1);
        books.add(b2);
        return books;
    }
}