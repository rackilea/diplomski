public class LoginResponse
{
   private String statusCode;

   private String resource_id;

   private String type;

    private String statusMessage;
    // getter and setters.
    .
    .
    @Override
    public String toString()
    {
        return "LoginResponse [statusCode = "+statusCode+", resource_id = "+resource_id+", type = "+type+", statusMessage = "+statusMessage+"]";
    }
}