import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;

public class Main {
    public static void main(String... args) {
        Schema schema = ReflectData.get().getSchema(Main.Foo.class);
        System.out.println(schema);
    }

    static class Foo {
        public static final String FIELD = "field";
    }
}