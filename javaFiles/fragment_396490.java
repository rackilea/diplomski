package com.him.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Test {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        jacksonTest();
    }

    private static void jacksonTest() throws JsonProcessingException, IOException {
        String jsonString = "{\"test1\": {\"get\": {\"tags\": [\"restcalls1\"]}}, \"test2\": {\"put\": {\"tags\": [\"restcalls2\"] }}}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonString);
        ArrayList<JsonNode> nodeList = new ArrayList<JsonNode>();
        nodeList.add(rootNode);

        printCompleteJson(nodeList);
    }

    private static void printCompleteJson(ArrayList<JsonNode> rootNode) throws IOException {
        for (int i = 0; i < rootNode.size(); i++) {
            Iterator<JsonNode> iterator = rootNode.get(i).iterator();
            JsonNode node = null;
            ArrayList<JsonNode> nodeList = new ArrayList<JsonNode>();
            boolean isEmpty = true;
            while (iterator.hasNext()) {
                isEmpty = false;
                node = iterator.next();
                nodeList.add(node);
                System.out.println(node);
            }
            if(isEmpty){
                return;
            }
            printCompleteJson(nodeList);
        }
    }
}