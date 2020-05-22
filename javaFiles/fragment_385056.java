List<String> words(char min, char max, int n) {
   List<String> ret = new ArrayList<String>();
   ret.add("");
   int start = 0;
   for(int length = 1; length <= n; ++length) {
      int end = ret.size();
      for(int i = 0; i < end; ++i) {
         for(char c = min; c <= max; ++c) {
            ret.add(ret.get(i) + c);
         }
      }
      start = end;
   }
   return ret;
}