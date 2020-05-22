@org.junit.jupiter.api.Test
public void testJson() throws JsonProcessingException {
    ArrayList<ArrayList<String>> input = new ArrayList<>();
    for(int i = 1; i<=10; i++) {
        input.add(new ArrayList<>(Arrays.asList(String.valueOf(2*i),String.valueOf(3*i))));
    }

    // This converts the Array to Json
    // This class is part of jackson library - https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.9.8
    ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(objectMapper.writeValueAsString(input));
}