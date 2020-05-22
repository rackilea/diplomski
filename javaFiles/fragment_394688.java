public static int returnCount(int n, int count, int max) {
    if (n > 0){
        if(n % 2 == 1)
            count++;
        else
            count = 0;
        n /= 2;
        max = Math.max(count, max);
        max = returnCount(n, count, max);           
    }
    return max;
}