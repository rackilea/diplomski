import com.google.gson.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.junit.Test;

import java.lang.reflect.Type;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

 public class MeTest {
    @Test
    public void test() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapter(MainDataObject.class, new ClassDeserializer())
                .create();
        String json = "{\"jobClass\":\"java.util.AbstractCollection\",\"time\":100,\"tables\":\"tables\"}";


        MainDataObject data = new MainDataObject("java.util.AbstractCollection");
        data.time = 100;
        data.tables = "tables";

        MainDataObject jobList = gson.fromJson(json, MainDataObject.class);

        assertThat(jobList, is(data));
    }
}

class ClassDeserializer implements JsonDeserializer<MainDataObject> {

    @Override
    public MainDataObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        String jobClassName = json.getAsJsonObject().get("jobClass").getAsString();
        MainDataObject mdo = new MainDataObject(jobClassName);
        mdo.tables = json.getAsJsonObject().get("tables").getAsString();
        mdo.time = json.getAsJsonObject().get("time").getAsInt();
        return mdo;
    }
}

// Lombok
@EqualsAndHashCode @ToString
class MainDataObject {
    Class<?> jobClass;
    int time;
    String tables;

    public MainDataObject(String jobClassname){
        try {
            jobClass =  (Class<?>)Class.forName(jobClassname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}