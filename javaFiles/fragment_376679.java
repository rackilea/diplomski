import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public static void main(String[] args) {
    final String json = "{ \"response-code\":\"4000\", \"response\": { \"result\": [ { \"DISPLAYNAME\":\"Backup Server\", \"AVAILABILITYSEVERITY\":\"5\", \"RESOURCEID\":\"10002239110\", \"TYPE\":\"SUN\", \"SHORTMESSAGE\":\"Clear\" } ] ,\"uri\":\"/json/ListAlarms\" } }";

    ObjectMapper mapper = new ObjectMapper();
    try {
        JsonNode obj = mapper.readTree(json);

        System.out.println(obj.get("response-code"));

        JsonNode response = obj.get("response");
        JsonNode firstResult = response.get("result").get(0);

        System.out.println(firstResult.get("DISPLAYNAME"));
        System.out.println(firstResult.get("AVAILABILITYSEVERITY"));
        System.out.println(firstResult.get("RESOURCEID"));
        System.out.println(firstResult.get("TYPE"));
        System.out.println(firstResult.get("SHORTMESSAGE"));
        System.out.println(response.get("uri"));
    } catch (IOException e) {
        e.printStackTrace();
    }

}