@Path("")
    public class RequestHandler 
    {
       @GET
       @Path("/get_quote")
       public String GetQuote()
       {
           return "GOdddd Working";
       }
    }