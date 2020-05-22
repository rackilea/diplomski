public static void separateArray(int[] numbers) {
    int i = 0;
    int j = numbers.length-1;
    while(i<j){
        if(numbers[i] > 0){ // FIXME: zero is not a "negative number"
            int temp;
            temp = numbers[j];
            numbers[j] = numbers[i];
            numbers[i] = temp;
        }
        i++; // FIXME: only advance left side if (numbers[i] < 0)
        j--;
    }
}