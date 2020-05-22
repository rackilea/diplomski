public class JsonMapExample {

public static void main(String[] args) {

    try {

        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"name\":\"mkyong\", \"age\":29}";

        Map<String, Object> map = new HashMap<String, Object>();

        // convert JSON string to Map
        map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});

        System.out.println(map);

    } catch (JsonGenerationException e) {
        e.printStackTrace();
    } catch (JsonMappingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
        }
    }

}