@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getResponse() {
    BookOfFriendsAnswer books = new BookOfFriendsAnswer();
    String id = "randomKey";  <===== Not sure if you want the key to be 
                                     the BookSummary id
    BookSummary summary = new BookSummary();
    summary.setId(id);
    summary.setTitle("Title 1");
    summary.getAuthors().add("Steve");
    summary.getAuthors().add("James");
    List<BookSummary> summaries = new ArrayList<>();
    summaries.add(summary);
    books.getBooks().put("randomKey", summaries);
    return Response.ok(books).build();
}