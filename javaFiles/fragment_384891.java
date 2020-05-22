// these variables are not really necessary
// int temp = 0;
// int isReverse;

public static int revNum(int d, int n){
    int temp = 0;
    for (int i = 0; i<(Math.log10(d)); i++) {
        temp *= 10;
        temp += n%10;
        n = (n - (n%10))/10;
    }
    return temp;
}   

public static boolean checkNum(int n) {
    return revNum(n,n) == n;
}

public static void main(String[] args) {
    for(int i = 10; i <1000; i++) {
         if(checkNum(i)) {
             System.out.println(i);
         }
    }
}