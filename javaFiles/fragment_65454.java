public static String findLongestPrefixSuffix(String s1, String s2) {

   if (s1.equals(s2)) { // this part is optional and will 
      return s1;        // speed things up if s1 is equal to s2
   }                    //

   int max = 0;
   for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
      if (s2.endsWith(s1.substring(0, i))) {
         max = i;
      }
   }
   return s1.substring(0, max);
}