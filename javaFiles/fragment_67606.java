package com.sujit;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class JSONTest {
        public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode nodes = mapper.readValue(new File("D:\\test.json"),ObjectNode.class);
            nodes.with("properties").put("Signature", "64237402i242840805749670 ");
            mapper.writer().writeValue(new File("D:\\test.json"), nodes); // Overwritting the file with new updated JSON data
        }
}