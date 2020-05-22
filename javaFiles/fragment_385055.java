List<String> words(char min, char max, int n) {
   List<String> ret = new ArrayList<String>();
   if(n == 0) {
      ret.add("");
      return ret;
   }
   for(String word : words(min, max, n - 1)) {
      for(char c = min; c <= max; ++c) {
         ret.add(word + c);
      }
   }
   return ret;
}