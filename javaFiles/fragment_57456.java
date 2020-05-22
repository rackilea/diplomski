public static int negFib(int n) {
    if(n==0 || n==1) {
        return n;
    }
    if(n==-1) {
        return 1;
    }
    if(n<0) {
        int sign = n % 2 == 0 ? -1 : 1;
        return sign * negFib(-n);
    } else {
        return negFib(n-1) + negFib(n-2);
    }     
}