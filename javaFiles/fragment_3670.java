@POST
@Path("/search")
public SearchResponse doSearch( 
   SearchRequest searchRequest, 
   @CookieParam("cookieName") Cookie cookie
) {
    //method body
}