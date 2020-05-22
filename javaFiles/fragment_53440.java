import java.util.*;

class Test {
   public static void main(String[] args) {
       // Key type is Character, value type is Integer
       Map<Character, Integer> map = new LinkedHashMap<>();
       String input = "ttaasjjikkk eee ";
       input = input.trim();
       for (int i = 0; i < input.length(); i++) {
           char c = input.charAt(i);
           Integer val = map.get(c);
           if (c != ' ') {
               if (val != null) {
                   map.put(c, val + 1);
               } else {
                   map.put(c, 1);
               }
           }
       }

       System.out.println(map);

       // Enhanced for loop to make it easier to iterate
       for (Map.Entry<Character, Integer> entry : map.entrySet()) {
           if (entry.getValue() == 1) {
               System.out.println("First non repeated character is: " 
                   + entry.getKey());
               return;
           }
       }
   }
}