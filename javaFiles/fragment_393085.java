@Path("/jason")
public class JavajsonRestApi {

private Booklist  bookList = new Booklist();

    @POST
    @Path("/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Book postJson(Book book) {
      bookList.addBook(book);
      return book;
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getJson() {
        return bookList.getAllBooks();
    }
}