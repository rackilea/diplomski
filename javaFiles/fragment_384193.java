import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();
        Gson gson = new GsonBuilder().create();

        Test test = gson.fromJson(new FileReader(jsonFile), Test.class);
        Test test1 = new TestTypeAdapter().fromJson(new FileReader(jsonFile));

        System.out.println(test);
        System.out.println(test1);
    }
}

class Test {

    private String foo;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    @Override
    public String toString() {
        return "Test{" +
                "foo='" + foo + '\'' +
                '}';
    }
}