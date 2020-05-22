import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String json = "{\n" +
                "  \"id\":\"1\",\n" +
                "  \"value\":13,\n" +
                "  \"text\":\"{\\\"Pid\\\":\\\"2\\\",\\\"value\\\":42}\"\n" +
                "}";

        MapObj mapObj = objectMapper.readValue(json, MapObj.class);
        System.out.println("text = " + mapObj.getText());
    }

    private static class MapObj {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("value")
        private Integer value;
        @JsonProperty("text")
        private String text;

        public Integer getId() {return id;}
        public void setId(Integer id) {this.id = id;}
        public Integer getValue() {return value;}
        public void setValue(Integer value) {this.value = value;}
        public String getText() {return text;}
        public void setText(String text) {this.text = text;}
    }
}