package jxtest;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

    public static void main(String[] args) throws IOException {
        TestPojo item = new TestPojo();
        item.setMyField1("Test1");
        item.setMyField2("Test2");
        item.setMyField3(42);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(item);

        System.out.println(json);

        TestPojo readBackIn = mapper.readValue(json, TestPojo.class);
        System.out.println(readBackIn.getMyField1());
        System.out.println(readBackIn.getMyField2());
        System.out.println(readBackIn.getMyField3());
    }
}