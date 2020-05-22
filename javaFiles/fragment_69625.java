@Path("/home")
@GET
@Produces(MediaType.TEXT_HTML)
public static String getIndexPage(){
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(MustacheFileName);
        StringWriter b = new StringWriter();
        try {
            mustache.execute(b, new MustacheObject()).flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b.toString();
}