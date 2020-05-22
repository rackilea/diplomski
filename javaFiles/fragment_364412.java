public class Fibonacci {

    public long fibo(long n){   
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        else
            return fibo(n-1) + fibo(n-2);
    }

    public static void main(String...args){

        int n = 20;
        Fibonacci f = new Fibonacci();
        for(int i = 0; i < n; i++){
            System.out.println(f.fibo(i));
        }
    }
}