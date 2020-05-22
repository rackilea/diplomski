import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class MapToJsonExample {
    private static final String pathToJsonResult = "example.json";

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> mapObject = new HashMap<String, Object>();

        mapObject.put("type", "person1");
        mapObject.put("id", null);

        List<Object> myList = new ArrayList<>();
        List<Double> point1 = Arrays.asList( 32.3619,50.9291 );
        List<Double> point2 = Arrays.asList( 32.3446,50.9395 );
        List<List<Double>> innerList = new ArrayList<>();
        List<List<List<Double>>> outerList = new ArrayList<>();
        innerList.add( point1 );
        innerList.add( point2 );
        outerList.add( innerList );
        mapObject.put( "values", outerList );

        try {
            objectMapper.writeValue(new File(pathToJsonResult), mapObject);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}