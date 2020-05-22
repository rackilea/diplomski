import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class AddJson {

    public static void main(String[] args) {
        String json = "{\"results\":[{\"lat\":\"value\",\"lon\":\"value\" }, { \"lat\":\"value\", \"lon\":\"value\"}]}";
        Gson gson = new Gson();
        JsonObject inputObj  = gson.fromJson(json, JsonObject.class);
        JsonObject newObject = new JsonObject() ;
        newObject.addProperty("lat", "newValue");
        newObject.addProperty("lon", "newValue");
        inputObj.get("results").getAsJsonArray().add(newObject);
        System.out.println(inputObj);
    }

}