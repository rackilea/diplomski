package com.maar.projectbuilder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Firat on 11.9.2014.
 */
public class Testt {
    @JsonDeserialize(as=StringClazz.class)
    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    @JsonTypeName(value = "StringClazz")
    private static class StringClazz{
        private String data="";

        public StringClazz() {
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
    public static void main(String[] args) throws IOException {
        StringClazz someOfString=new StringClazz();
        someOfString.setData("someOfString");
        StringClazz differentString=new StringClazz();
        differentString.setData("differentString");

        List<StringClazz> list=new ArrayList<StringClazz>();
        list.add(someOfString);
        list.add(someOfString);
        list.add(differentString);

        for(Object str:list){
            System.out.println(str.hashCode());
        }
        System.out.println(list.get(0)==list.get(1));
        System.out.println(list.get(0)==list.get(2));
        System.out.println("-------");
        String json= null;
        try {
            json = new ObjectMapper().enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL).writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        List<StringClazz> listDeserilized =new ObjectMapper().enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL).readValue(json, new TypeReference<List<StringClazz>>() {
        });
        for(Object str:listDeserilized){
            System.out.println(str.hashCode());
        }
        System.out.println(listDeserilized.get(0)==listDeserilized.get(1));
        System.out.println(listDeserilized.get(0)==listDeserilized.get(2));
    }
}