static final String TEST_JSON = "{"
            +" \"aaa@example.com\": {"
            +"  \"statement\": true,"
            +"  \"another_property\" : \"value 1\"" 
            +"},"
            +"\"bbb@example.com\": {"
            +"  \"statement\": false,"
            +"  \"another_property\" : \"value 2\"" 
            +"}"
            +"}";    
//...    
public static void main (String... args) {
    //...
    Map<String, Map<String, Object>> jsonAsNestedMap = mapper.readValue(
                    TEST_JSON, new TypeReference<Map<String, Map<String, Object>>>() {

        });
//...
}