@Path("/book")
@GET
public Object getBooks(@QueryParam("chapter") String chapter, @QueryParam("page") String page) {
    if (chapter == null && page == null)
      return getAllBooks();
    else if (chapter == null)
      return getBooksByPages(...);
    else if (page == null)
      return getBooksByChapters(...);
    else
      return getBooksByPagesAndChapters(...);
}