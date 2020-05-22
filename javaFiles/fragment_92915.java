public static int numGreater(int[] a, int val) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();         
      }

      int answer = 0;

      for (int i = 0; i < a.length; i++) {
         if (a[i]>val) {
            answer++;
         }       
      }         


      return answer;
   }