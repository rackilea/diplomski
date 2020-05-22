public class Prime {

public static void main(String[] arg) {
    for(int i = 1; i < 10; i++) {
        int res = isPrime(i, i -1);
        if(res == 1){
            System.out.println(i +" is a prime number");
        }
        else{
            System.out.println(i +" not a prime number");
        }
    }
}

static int isPrime(int a, int div) {
    if(div <= 1) {
        return 1;
    }
    if(a % div == 0) {
        return -1;
    }
    return isPrime(a, div-1);
}
}