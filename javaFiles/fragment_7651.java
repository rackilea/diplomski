package com;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        String jsonStr = "{\n" +
                "    \"name\": \"John\", \n" +
                "    \"id\": 1, \n" +
                "    \"details\": [\n" +
                "        {\n" +
                "            \"item\": 2, \n" +
                "            \"count\": 10\n" +
                "        },\n" +
                "        {\n" +
                "            \"item\": 3, \n" +
                "            \"count\": 5\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        try{
            Proposal proposal =  mapper.readValue(jsonStr,Proposal.class);
            System.out.println(proposal);
        }catch(Exception ioe){
            ioe.printStackTrace();
        }

    }
}


class Proposal {

    private String name;

    private Integer id;

    private List<Detail> details;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    // Setters and getters
}

class Detail {

    private Integer item;

    private Integer count;

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}