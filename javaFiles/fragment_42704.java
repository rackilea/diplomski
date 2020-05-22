import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class Test
{
    public static void main(String... args)
    {
        String input1 = "{\"state\":1,\"cmd\":1}";
        String input2 = "{\"cmd\":1,\"state\":1}";
        ObjectMapper om = new ObjectMapper();
        try {
            Map<String, Object> m1 = (Map<String, Object>)(om.readValue(input1, Map.class));
            Map<String, Object> m2 = (Map<String, Object>)(om.readValue(input2, Map.class));
            System.out.println(m1);
            System.out.println(m2);
            System.out.println(m1.equals(m2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}