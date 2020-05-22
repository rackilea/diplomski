public static int maxDigit(int n){
    if(n==0)                               // Base case: if n==0, return 0
        return 0;
    return Math.max(n%10, maxDigit(n/10)); // Return max of current digit and 
                                           // maxDigit of the rest 
}