public static boolean isPrime(int n)
{
       if( n % 2 == 0 ) {
           return false;
       }
       double root = Math.sqrt(n);
       for ( int i = 3; i < root; i+=2 ) {
           if( n % i == 0 ) { 
               return false;
           }
       }
       return true;
}