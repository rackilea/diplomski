import org.json.JSONObject;

public class App 
{
    public static void main( String[] args )
    {
        String message = "{'message': 'hello'}";
        JSONObject json = new JSONObject(message);

        System.out.println(json.get("message"));
    }
}