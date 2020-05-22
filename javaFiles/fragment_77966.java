package jmv;

public class euler3 {
    static int x=1;
    static long z = 600851475143L;
    public static void main(String[] args) {
        System.out.println(isPrime(123454321));
    }

    public static boolean isPrime(int p){
        if (p%2 == 0) {
            return false;
        } else  {
            for(int y=3 ; y<p ; y=y+2){
                if(p%y == 0){
                    return false; 
                }          
            }
        }
        return true;
     }
 }