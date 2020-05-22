public static int removeNegativeNumbers(int[] num) {
    int k = 0;
    for(int i = 0; i < num.length; i++) {
       if(num[i] >= 0) {
           num[k++] = num[i];
       }
    }
    // Now input array is holding the output data
    // Return the length of output array
    return k;
}

// Usage: int newLen = removeNegativeNumbers(array);