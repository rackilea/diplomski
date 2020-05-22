public static double[] Teiler(double[] a, boolean r){
   double[] hilf;
   int x = 0;
   if(r == false){
       hilf = new double[(int) a.length / 2];
       for(int i = 0; i < a.length / 2; i++){
           hilf[x] = a[i];
           i ++;
       }
   } else{
       hilf = new double[(int) (a.length / 2) + (a.length % 2)];
       for(int i = a.length / 2; i < a.length; i++){
           hilf[x] = a[i];
           i ++;
       } 
   }
   return hilf;
}