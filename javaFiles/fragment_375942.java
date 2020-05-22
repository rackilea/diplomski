public static int[] removeNegativeNumbers(int[] num) {
    int[] output = new int[num.length];
    int k = 0;
    for(int i = 0; i < num.length; i++) {
       if(num[i] >= 0) {
           output[k++] = num[i];
       }
    }
    return Arrays.copyOfRange(output, 0, k);
}