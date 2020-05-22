@Path("books")
public class BookResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> findBooks(@QueryParam("genre") String genre,
                                @QueryParam("author") String author) {
        ...
    }
}