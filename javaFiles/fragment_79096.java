@Path("/books")
@Produces({"application/xml", "application/json"})
public class Bookstore {

    @AddLinks
    @LinkResource(value = Book.class)
    @GET
    @Formatted
    public Collection<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book", "Author"));
        return books;
    }
}