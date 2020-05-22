import com.jayway.jsonpath.JsonPath;

import java.net.URL;
import java.util.List;

public class JsonPathApp {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://gcc.azure-api.net/traffic/v1/movement/now");

        List<Integer> flows = JsonPath.parse(url).read("$[*].flow");
        System.out.println(flows);
    }
}