public static int getMaxIndex(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
        int newnumber = numbers[i];
        if ((newnumber > numbers.length)) {
            maxIndex = i;
        }
    }
    return maxIndex;

}