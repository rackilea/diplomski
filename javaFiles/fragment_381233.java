public interface ReadOnlyAtomFeed {
    @GET @Produces("application/atom+xml")
    Feed getFeed();
}

@Path("feed")
public class ActivityLog implements ReadOnlyAtomFeed {
    public Feed getFeed() {...}
}