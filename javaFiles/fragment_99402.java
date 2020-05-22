package com.abhi.learning.stackoverflow;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
* Hello world!
*
*/
public class App 
{
    public static void main( String[] args )
    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Example emp = new Example();
        ArrayList<String> al = new ArrayList<String>();
        al.add("Critical");
        al.add("Error ");
        al.add("Warning ");

        emp.setSynonyms(al);

        emp.setValue("Severity");


        Example emp1 = new Example();
        ArrayList<String> al1 = new ArrayList<String>();
        al1.add("Inciden");
        al1.add("Risk");
        al1.add("Event");

        emp1.setSynonyms(al1);

        emp1.setValue("Imapct");

        List<Example> lstEx = new ArrayList<Example>();
        lstEx.add(emp1);
        lstEx.add(emp);
        try {
            objectMapper.writeValue(new File("target/employee.json"), lstEx);
        } catch ( IOException e) {
            e.printStackTrace();
        } 
    }
}