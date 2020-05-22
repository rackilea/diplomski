import org.json.JSONObject;

public class JsonTest 
{
    public static void main( String[] args )
    {
        String json = "{\"session\": {\"token\":\"xxxx\"}}";
        JSONObject jObject= new JSONObject(json);
        String token = jObject.getJSONObject("session").getString("token");
        System.out.printf("Token %s" , token);
    }
}