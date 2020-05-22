class FibR
{
   int c = 0 ;
   void fib(int i, int j, int n){
     if (c >= n) return;
     System.out.print(i+" " + j +" ");
     int t = j;
     i += j;
     j = i + t;
     c += 2;
     fib(i, j, n);     
   }

   public static void main(String[] args) {
       FibR f = new FibR();
       f.fib(0, 1, 5);
       System.out.println();
    }
}