@Path("/books")
public class BookService {

    @GET
    @Path("{year}")
    public Response getBooks(@PathParam("year") String year,
            @MatrixParam("author") String author,
            @MatrixParam("country") String country) {

        return Response
            .status(200)
            .entity("getBooks is called, year : " + year
                + ", author : " + author + ", country : " + country)
            .build();

    }

}