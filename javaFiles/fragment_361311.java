public static void main(String[] args)
{
 int[] array = new int[10];
  for(int i = 0; i < array.length; i++) {
   array[i] = (int)(Math.random()*100);}

   System.out.println("\nBefore Bubble Sort: ");
    for (int element : array)
      System.out.print(element + "  "); 

   int[] sorted = array.clone();
   bubbleSort(sorted);


   System.out.println("After Bubble Sort: "); 
    for (int element : sorted)
      System.out.print(element + "  ");
      System.out.println("\n");

   System.out.println("\nBefore Insertion Sort: ");
    for (int element : array)
        System.out.print(element + "  "); 

    sorted = array.clone();
    insertionSort(sorted);


    System.out.println("After Insertion Sort: "); 
    for (int element : sorted)
        System.out.print(element + "  ");
    System.out.println("\n");
}