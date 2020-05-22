public static int getEvenAvg(int[] a, int n, int ct, int sum) {
    if (n == -1) {
        //make sure you handle the case
        //when count of even numbers is zero
        //otherwise you'll get Runtime Error.
        return sum/ct;
    }
    if (a[n]%2 == 0) {
        ct++;
        sum+=a[n];
    }
    return getEvenAvg(a, n - 1, ct, sum); 
}