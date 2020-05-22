public static void method(List<Integer> list, int n, int m) {
   if (n < 0) {
       process(list);
   } else {
      for(int i = 0; i < m; i++) {
         list.set(n, i);
         method(list, n-1, m);
      }
   }
}