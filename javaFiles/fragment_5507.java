import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {
    public static void main(String[] args) throws JsonParseException, IOException {
        File file = new File("C:\\test_java\\jackson.json"); 

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(file);

        //Get the full name 
        String fullName = root.path("retweeted_status").path("place").path("full_name").asText(); 

        System.out.println("full_name: " + fullName);

        //Get the coordinate array
        JsonNode coordinates = root.path("retweeted_status").path("place").path("bounding_box").path("coordinates").get(0);

        //print the whole array of array 
        System.out.println(coordinates.toString());

        //print individual arrays, where each is lat and long 
        System.out.println(coordinates.get(0));
        System.out.println(coordinates.get(1));
        System.out.println(coordinates.get(2));
        System.out.println(coordinates.get(3));

        //print lat and long of each array seperately
        System.out.println(coordinates.get(0).get(0));
        System.out.println(coordinates.get(0).get(1));

        System.out.println(coordinates.get(1).get(0));
        System.out.println(coordinates.get(1).get(1));

        System.out.println(coordinates.get(2).get(0));
        System.out.println(coordinates.get(2).get(1));

        System.out.println(coordinates.get(3).get(0));
        System.out.println(coordinates.get(3).get(1));
    }
}