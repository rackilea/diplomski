import com.model.Foo;
import com.model.Pojo;
import com.model.Pojo1;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GsonApp {

    public static void main(String[] args) {
        System.out.println("Pojo + Map: ");
        Pojo pojo = new Pojo();
        pojo.put("character1", new Foo("Morty", 15));
        pojo.put("character2", new Foo("Rick", 60));

        System.out.println(serialize(pojo));
        System.out.println();

        System.out.println("Map only: ");
        Pojo1 pojo1 = new Pojo1();
        pojo1.put("int1", 1);
        pojo1.put("int2", 22);
        System.out.println(serialize(pojo1));
        System.out.println();

        System.out.println("Pojo only:");
        System.out.println(serialize(new Pojo()));
        System.out.println();
    }

    private static final Gson gson = createGson();

    private static Gson createGson() {
        MixedJsonSerializer adapter = new MixedJsonSerializer();
        return new GsonBuilder()
                .setPrettyPrinting()
                // in case you have many classes you need to use reflection
                // to register adapter for each needed class.
                .registerTypeAdapter(Pojo.class, adapter)
                .registerTypeAdapter(Pojo1.class, adapter)
                .create();
    }

    private static String serialize(Object obj) {
        return gson.toJson(obj);
    }
}