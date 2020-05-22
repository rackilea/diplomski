private static Random r;

public static void shuffle(List<?> list) {

         if (r == null) {
             r = new Random();
         }
         shuffle(list, r);
     }