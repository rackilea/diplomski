long start = System.nanoTime();
int sortedArr[] = selectionSort(arr1);
long elapsed = System.nanoTime() - start;

System.out.println("\n///////////SELECTIONSort//////////////");
System.out.println("\nSelection sort implemented below prints a sorted list:");
print(sortedArr);
System.out.printf("It took %.3f ms....", elapsed / 1e6);