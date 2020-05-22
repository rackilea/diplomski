@GET
@Path("/article/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Response getArticle(@PathParam("id") long id) {
       Article myArticle = getArticleById(id);
       return Response.ok(myArticle);
}

@GET
@Path("/article/{id}")
@Produces(MediaType.TEXT_HTML)
public Response getArticleHtml(@PathParam("id") long id) {
    InputStream myHtml = getClass().getClassLoader().getResourceAsStream("/path/to/html.html");
    return Response.ok(myHtml).build();
}