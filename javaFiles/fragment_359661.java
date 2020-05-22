iterateArray(array, 0);  // 0 is the start index.


// The 'iterateArray()' method:
private static int iterateArray(int[] array, int index) {
    System.out.println(array[index]);
    index++; 
    if (index == array.length) {
        return 0;
    }
    return iterateArray(array,index);
}