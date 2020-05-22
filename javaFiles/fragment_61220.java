public class Comments {
 // handles url path like  /comments/12/likes?offset=15 
 @WebMethod(MethodType.GET)
  @WebURL("comment/:id/likes/") 
  public void listLikes(@WebParameter(name="offset") int offset, @URLParam("id") long id) {
  //operatio to Do  so here offset will be 15  ,id 12
}
}