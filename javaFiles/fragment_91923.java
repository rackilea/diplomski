for(int iter = 1; iter<=100000; iter *= 10) {
    long start = System.nanoTime();
    int[] sortedArr = null
    for(int i=0;i<iter;i++) 
        sortedArr = selectionSort(arr1);
    long elapsed = System.nanoTime() - start;

    System.out.println("\n///////////SELECTIONSort//////////////");
    System.out.println("\nSelection sort implemented below prints a sorted list:");
    print(sortedArr);
    System.out.printf("It took %.3f ms on average....", elapsed / 1e6 / iter);
}