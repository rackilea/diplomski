@ManagedBean(name = "restController")
@SessionScoped
@Resource(name = "movie")
@Path("/movie")
public class MovieResource
{
    @EJB
    private MovieEJB movieEJB;

    public MovieResource()
    {

    }

    public MovieEJBLocal getMovieEJB()
    {
        return movieEJB;
    }

    public void setMovieEJB(MovieEJBLocal movieEJB)
    {
        this.movieEJB = movieEJB;
    }

    @POST
    @Path("/post")
    @Consumes(
    {
        MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
    })
    public Response createMovie(Movie movie)
    {
        getMovieEJB().create(movie);
        String result = "Movie created : " + movie;
        return Response.status(201).entity(movie).build();
    }
}