import java.util.*;

class Test { 
    private static void test(Map<String, String> a, int b) {
        a.put("test", "def");
        b = 10; 
    }

    public static void main(String[] args) {
        Map<String, String> a = new HashMap<String, String>();
        a.put("test", "abc");

        int b = 5;

        test(a, b); 

        System.out.println(a);
        System.out.println(b);
    }   
}