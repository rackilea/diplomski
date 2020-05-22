import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        String json = "{\"firstParam\":[1],\"secondParam\": [\"a\",\"b\",\"c\",\"d\"],\"thirdParam\": [1,2,3],\"fourthParam\":[true,false]}";

        TypeReference<LinkedHashMap<String, List<String>>> mapOfStringListsType = new TypeReference<LinkedHashMap<String, List<String>>>() {};
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<String>> map = mapper.readValue(json, mapOfStringListsType);
        map.forEach((k, v) -> {
            System.out.print(k + " => ");
            v.forEach(i -> System.out.print(i + " (" + i.getClass().getSimpleName() + "), "));
            System.out.println();
        });
    }
}