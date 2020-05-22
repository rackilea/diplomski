import java.util.*;

public class TestArrayComparator {
   public static Map<Character, Integer> freq = new HashMap<>();
   static {
      freq.put('b',3);
      freq.put('y',2);
      freq.put('e',1);
   }
   public static void main(String[] args) {
      Character[] input = new Character[]{'b','e','y'};

      Arrays.sort(input, new Comparator<Character>() {
         @Override
         public int compare(Character o1, Character o2) {
            return freq.get(o2) - freq.get(o1);
         }
      });
      System.out.println(Arrays.toString(input));
   }
}
//outputs ['b','y','e']