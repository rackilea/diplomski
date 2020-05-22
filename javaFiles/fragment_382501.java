public static boolean isConsecutive(int[] a) {
     for (int i = 0; i < 3; i++) {
         if (!(a[i] == a[i + 1])) {
             return false;
         }
     }
     return true;
 }