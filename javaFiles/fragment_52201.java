public class Application extends org.restlet.Application {

    public static void main(String... args) throws Exception {
        // Create a component with an HTTP server connector
        final Component comp = new Component();
        comp.getServers().add(Protocol.HTTP, 3000);

        // Attach the application to the default host and start it
        comp.getDefaultHost().attach("/v1", new Application());
        comp.start();
    }

    private final ObjectContainer container;

    /**
     * Constructor.
     */
    public Application() {
        /** Open and keep the db4o object container. */
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().updateDepth(2);
        this.container = Db4oEmbedded.openFile(config, System
                .getProperty("user.home")
                + File.separator + "restbook.dbo");
    }

    @Override
    public Restlet createInboundRoot() {
        final Router router = new Router(getContext());

        // Add a route for user resources
        router.attach("/users/{username}", UserResource.class);

        // Add a route for user's bookmarks resources
        router.attach("/users/{username}/bookmarks", BookmarksResource.class);

        // Add a route for bookmark resources
        final TemplateRoute uriRoute = router.attach(
                "/users/{username}/bookmarks/{URI}", BookmarkResource.class);
        uriRoute.getTemplate().getVariables().put("URI",
                new Variable(Variable.TYPE_URI_ALL));

        return router;
    }

    /**
     * Returns the database container.
     * 
     * @return the database container.
     */
    public ObjectContainer getContainer() {
        return this.container;
    }
}


/** resource class (UserResource.java) has these functions
/**
 * Returns the parent application.
 * 
 * @return the parent application.
 */
@Override
public Application getApplication() {
    return (Application) super.getApplication();
}

/**
 * Returns the database container.
 * 
 * @return the database container.
 */
public ObjectContainer getContainer() {
    return getApplication().getContainer();
}