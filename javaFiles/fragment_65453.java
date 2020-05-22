public String findLongestPrefixSuffix(String s1, String s2) {

   for( int i = Math.min(s1.length(), s2.length()); ; i--) {
      if(s2.endsWith(s1.substring(0, i))) {
         return s1.substring(0, i);
      }
   }    
}