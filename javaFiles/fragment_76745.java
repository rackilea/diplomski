import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class JsonApp {

    private static final String json = "{\"A\" : 1.0 ,\"B\" : \"X\"}";

    private static final int MAX = 1_000_000;

    private static List<List<Duration>> values = new ArrayList<>();

    static {
        IntStream.range(0, 4).forEach(i -> values.add(new ArrayList<>()));
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            int v = 0;
            values.get(v++).add(defaultGson());
            values.get(v++).add(gsonAdapter());
            values.get(v++).add(defaultJackson());
            values.get(v).add(jacksonJsonFactory());
        }
        values.forEach(list -> {
            list.forEach(d -> System.out.print(d.toMillis() + " "));
            System.out.println(" avg " + list.stream()
                    .mapToLong(Duration::toMillis)
                    .average().getAsDouble());
        });
    }

    static Duration defaultGson() {
        Gson gson = new Gson();

        long start = System.nanoTime();
        for (int i = MAX; i > 0; i--) {
            gson.fromJson(json, Pojo.class);
        }

        return Duration.ofNanos(System.nanoTime() - start);
    }

    static Duration gsonAdapter() throws IOException {
        PojoTypeAdapter adapter = new PojoTypeAdapter();

        long start = System.nanoTime();
        for (int i = MAX; i > 0; i--) {
            adapter.fromJson(json);
        }

        return Duration.ofNanos(System.nanoTime() - start);
    }

    static Duration defaultJackson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        long start = System.nanoTime();
        for (int i = MAX; i > 0; i--) {
            mapper.readValue(json, Pojo.class);
        }

        return Duration.ofNanos(System.nanoTime() - start);
    }

    static Duration jacksonJsonFactory() throws IOException {
        JsonFactory jfactory = new JsonFactory();

        long start = System.nanoTime();
        for (int i = MAX; i > 0; i--) {
            readPartially(jfactory);
        }
        return Duration.ofNanos(System.nanoTime() - start);
    }

    static Pojo readPartially(JsonFactory jfactory) throws IOException {
        try (JsonParser parser = jfactory.createParser(json)) {

            Pojo pojo = new Pojo();

            parser.nextToken(); // skip START_OBJECT - {
            parser.nextToken(); // skip A name
            parser.nextToken();
            pojo.A = parser.getDoubleValue();
            parser.nextToken(); // skip B name
            parser.nextToken();
            pojo.B = parser.getValueAsString();

            return pojo;
        }
    }
}

class PojoTypeAdapter extends TypeAdapter<Pojo> {

    @Override
    public void write(JsonWriter out, Pojo value) {
        throw new IllegalStateException("Implement me!");
    }

    @Override
    public Pojo read(JsonReader in) throws IOException {
        if (in.peek() == com.google.gson.stream.JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        Pojo pojo = new Pojo();

        in.beginObject();
        in.nextName();
        pojo.A = in.nextDouble();
        in.nextName();
        pojo.B = in.nextString();

        return pojo;
    }
}

class Pojo {

    double A;
    String B;

    @Override
    public String toString() {
        return "Pojo{" +
                "A=" + A +
                ", B='" + B + '\'' +
                '}';
    }
}