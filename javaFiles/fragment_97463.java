@Path("/login")
 public class LoginWS {

   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public NameBean getHello( NameBean nb ) throws JSONException{
     System.out.println("starting pt");
     String output="Hello "+ nb.getName();
     nb.setName(output);
     return nb;
   }

 }