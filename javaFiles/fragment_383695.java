private static void binary(int n){
       String t = ""; int N = 1<<n;
       for (int i=0; i<n;i++) t += "0";
       for (int i = 1; i < N; i++) {
             String s = Integer.toBinaryString(i);
             System.out.println(t.substring(s.length())+s);
       }
    }