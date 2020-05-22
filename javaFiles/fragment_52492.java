import java.util.*;

public class test {
   public static void main(String... args) {
      String s[] = {"Qh", "Jd", "2h"};
      Arrays.sort(s, new Comparator<String>() {
         @Override
         public int compare (String s1, String s2) {
            int v1 = (int) s1.charAt(0);
            int v2 = (int) s2.charAt(0);
            if (v1 == 65) v1 = 100; //changes the value of A
            if (v2 == 65) v2 = 100;
            if (v1 == 75) v1 = 85; //changes the value of K
            if (v2 == 75) v2 = 85;
            if (v1 == 84) v1 = 60;
            if (v2 == 84) v2 = 60; //changes the value of T
            return v1 - v2;
         }
      });
      for (String card : s) {
         System.out.println(card);
      }   
   }
}