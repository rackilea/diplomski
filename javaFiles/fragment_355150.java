@Data
public class Example {
    private String responseStatus;
    private ResponseDetails responseDetails;
    private List<Data> data;

    @lombok.Data
    public static class ResponseDetails {
        private int limit;
        private int offset;
        private int size;
        private int total;
    }

    @lombok.Data
    public static class Data {
        private String id;
        private String name__v;
        private String abbreviation__c;
        private String internal_name__c;
        private String external_id__v;
        private String generic_name__c;
        private Object scientific_name__c;
        private List<String> status__v;
        private List<String> therapeutic_area__c;
    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {
        @JsonProperty("name__v")
        private String fNumber;
        @JsonProperty("generic_name__c")
        private String genericName;
        @JsonProperty("scientific_name__c")
        private String scientificName;
        @JsonProperty("therapeutic_area__c")
        private List<String> therapeuticArea;
    }

    public static void main(String[] args) {
        String jsonResult = "{\"responseStatus\":\"SUCCESS\",\"responseDetails\":{\"limit\":1000,\"offset\":0,\"size\":2,\"total\":2},\"data\":[{\"id\":\"00P000000001M01\",\"name__v\":\"Foo\",\"status__v\":[\"active__v\"],\"abbreviation__c\":\"F170053\",\"internal_name__c\":\"Foo\",\"therapeutic_area__c\":[\"neurology__c\"],\"external_id__v\":\"84\",\"generic_name__c\":\"Foo\",\"scientific_name__c\":null},{\"id\":\"00P000000001N01\",\"name__v\":\"Bar\",\"status__v\":[\"active__v\"],\"abbreviation__c\":\"B333334\",\"internal_name__c\":\"Bar\",\"therapeutic_area__c\":[\"bone_muscle_joint__c\"],\"external_id__v\":\"101\",\"generic_name__c\":\"Bar\",\"scientific_name__c\":null}]}";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Example example = objectMapper.readValue(jsonResult, new TypeReference<Example>() {
            });
            //you can get data[] via example.getData()
            System.out.println(objectMapper.writeValueAsString(example.getData()));

            List<Product> products = objectMapper.readValue(objectMapper.writeValueAsString(example.getData()), new TypeReference<List<Product>>() {
            });
            //you can also parse data[] as List<Product>
            System.out.println(JSONObject.toJSONString(products));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}