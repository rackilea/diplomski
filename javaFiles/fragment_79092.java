@Path("/books")
public class BookResource {

    private final Map<Integer, Book> booksDB 
            = Collections.synchronizedMap(new LinkedHashMap<Integer, Book>());
    private final AtomicInteger idCounter = new AtomicInteger();

    public BookResource() {
        Book book = new Book("Book One", "Author One");
        booksDB.put(idCounter.incrementAndGet(), book);

        book = new Book("Book Two", "Author Two");
        booksDB.put(idCounter.incrementAndGet(), book);

        book = new Book("Book Three", "Author Three");
        booksDB.put(idCounter.incrementAndGet(), book);

        book = new Book("Book Four", "Author Four");
        booksDB.put(idCounter.incrementAndGet(), book);

        book = new Book("Book Five", "Author Five");
        booksDB.put(idCounter.incrementAndGet(), book);
    }

    @GET
    @Formatted
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public BookStore getBook(@Context UriInfo uriInfo, @PathParam("id") int id) {
        List<Link> links = new ArrayList<>();
        Collection<Book> books = new ArrayList<>();

        UriBuilder uriBuilder = uriInfo.getBaseUriBuilder();
        uriBuilder.path("books");
        uriBuilder.path("{id}");

        Book book = booksDB.get(id);
        if (book == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        synchronized(booksDB) {
            if (id + 1 <= booksDB.size()) {
                int next = id + 1;
                URI nextUri = uriBuilder.clone().build(next);
                Link link = Link.fromUri(nextUri).rel("next").type(MediaType.APPLICATION_XML).build();
                links.add(link);
            }
            if (id - 1 > 0) {
                int previous = id - 1;
                URI nextUri = uriBuilder.clone().build(previous);
                Link link = Link.fromUri(nextUri).rel("previous").type(MediaType.APPLICATION_XML).build();
                links.add(link);
            }
        }

        books.add(book);
        BookStore bookStore = new BookStore();
        bookStore.setLinks(links);
        bookStore.setBooks(books);
        return bookStore;
    }
}