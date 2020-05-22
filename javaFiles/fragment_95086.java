@WebService
public class SimpleWs
{
    @WebMethod
    public String upload(String textfield, byte[] filefield) {
        // ...
        return "OK";
    }
}