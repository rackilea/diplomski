void words(char min, char max, int n) {
   for(int i = 0; i <= n; ++i) {
      wordsRecursive("", min, max, i);
   }
}

void wordsRecursive(String base, char min, char max, int n) {
   if(n == 0) {
      System.out.println(base);
   } else {
      for(char c = min; c <= max; ++c) {
         wordsRecursive(base + c, min, max, n - 1);
      }
   }
}