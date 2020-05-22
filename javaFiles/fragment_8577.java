import elemental.json.Json;
import elemental.json.JsonArray;
import elemental.json.JsonValue;
import elemental.json.impl.JsonUtil;
import org.junit.Test;

public class JsonTest {

    @Test
    public void shouldParseJson() {
        JsonArray array = JsonUtil.parse("[\n" +
                "    {'type': 'rectangle', 'x':50, 'y':50, 'width': 50, 'height': 50},\n" +
                "    {'type': 'circle', 'x':75, 'y':150,  'r' : 20}, \n" +
                "    {'type': 'rectangle', 'x':50, 'y':200, 'width' : 100, 'height': 20},\n" +
                "    {'type': 'circle', 'x':75, 'y':300,  'r' : 30}, \n" +
                "]");


        System.out.println("Parsed string array:\n" + JsonUtil.stringify(array, 2));
    }


    @Test
    public void shouldCreateArray() {
        //for the sake of brevity I'll create the object by also parsing a string, but you get the general idea
        JsonValue object = JsonUtil.parse("{'type': 'rectangle', 'x':50, 'y':50, 'width': 50, 'height': 50}");
        JsonArray array = Json.createArray();
        array.set(0, object);

        System.out.println("Manually created array:\n" + JsonUtil.stringify(array, 2));
    }
}