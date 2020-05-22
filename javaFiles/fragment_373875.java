import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.beans.property.StringProperty;

public class PropertySerializationTest {
    public static void main(String[] args) {
        final DatabaseEntry entry = new DatabaseEntry("toolhouse", 18, 16, "Property");
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(StringProperty.class, new StringPropertyAdapter());
        final Gson gson = gsonBuilder.create();

        System.out.println("Serialized Data:");
        String json = gson.toJson(entry);
        System.out.println(json);

        System.out.println("De-serialized/Re-serialized Data:");
        DatabaseEntry rebuiltEntry = gson.fromJson(json, DatabaseEntry.class);
        String rebuiltJson = gson.toJson(rebuiltEntry);
        System.out.println(rebuiltJson);
    }
}